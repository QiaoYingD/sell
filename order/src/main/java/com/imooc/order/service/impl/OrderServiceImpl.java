package com.imooc.order.service.impl;

import com.imooc.order.dto.OrderDTO;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.mapper.OrderDetailMapper;
import com.imooc.order.mapper.OrderMasterMapper;
import com.imooc.order.model.OrderMasterModel;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //TODO 查询商品信息（调用商品服务）
        //TODO 计算总价
        //TODO 扣库存（调用商品服务）

        //订单入库
        OrderMasterModel orderMasterModel = new OrderMasterModel();
        orderDTO.setOrderId(KeyUtil.getInstance().getFinalNumber());
        BeanUtils.copyProperties(orderDTO, orderMasterModel);
        orderMasterModel.setOrderAmount(new BigDecimal(5));
        orderMasterModel.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMasterModel.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterModel.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        orderMasterMapper.save(orderMasterModel);
        return orderDTO;
    }
}
