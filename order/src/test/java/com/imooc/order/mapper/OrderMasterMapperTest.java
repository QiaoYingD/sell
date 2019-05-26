package com.imooc.order.mapper;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.model.OrderMasterModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@Component
public class OrderMasterMapperTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Test
    public void save(){

        OrderMasterModel orderMasterModel=new OrderMasterModel();
        orderMasterModel.setOrderId("2");
        orderMasterModel.setBuyerName("zs");
        orderMasterModel.setBuyerPhone("123456");
        orderMasterModel.setBuyerAddress("中国");
        orderMasterModel.setBuyerOpenid("1974218313");
        orderMasterModel.setOrderAmount(new BigDecimal(0.02));
        orderMasterModel.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMasterModel.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterModel.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        orderMasterMapper.save(orderMasterModel);
    }

    @Test
    public void getList(){

    }

}