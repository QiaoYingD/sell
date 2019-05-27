package com.imooc.order.service.impl;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dto.CartDTO;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.mapper.OrderDetailMapper;
import com.imooc.order.mapper.OrderMasterMapper;
import com.imooc.order.model.OrderDetailModel;
import com.imooc.order.model.OrderMasterModel;
import com.imooc.order.model.ProductInfoModel;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.KeyUtil;
import com.imooc.order.utils.UUIDUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private ProductClient productClient;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.getInstance().getFinalNumber();
        //查询商品信息（调用商品服务）
        List<String> productIdList = orderDTO.getOrderDetailModels().stream().map(OrderDetailModel::getProductId).collect(Collectors.toList());
        List<ProductInfoModel> productInfoModels = productClient.listForOrder(productIdList);
        //计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        for (OrderDetailModel orderDetailModel : orderDTO.getOrderDetailModels()) {
            for (ProductInfoModel productInfoModel : productInfoModels) {
                if (productInfoModel.getProductId().equals(orderDetailModel.getProductId())) {
                    //单价*数量
                    orderAmout = productInfoModel.getProductPrice().multiply(new BigDecimal(orderDetailModel.getProductQuantity())).add(orderAmout);
                    BeanUtils.copyProperties(productInfoModel, orderDetailModel);
                    orderDetailModel.setOrderId(orderId);
                    orderDetailModel.setDetailId(UUIDUtil.genUniqueKey());
                    orderDetailModel.setCreateTime(sFormat.format(new Date()));

                    orderDetailMapper.save(orderDetailModel);
                }
            }
        }
        //扣库存（调用商品服务）
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailModels().stream().map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        //订单入库
        OrderMasterModel orderMasterModel = new OrderMasterModel();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMasterModel);
        orderMasterModel.setOrderAmount(orderAmout);
        orderMasterModel.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMasterModel.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterModel.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        orderMasterMapper.save(orderMasterModel);
        return orderDTO;
    }
}
