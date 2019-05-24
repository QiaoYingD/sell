package com.imooc.order.mapper;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.model.OrderMasterModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Component
public class OrderMasterMapperTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterMapper orderMasterMapper;

    @Test
    public void save(){

        OrderMasterModel orderMasterModel=new OrderMasterModel();
        orderMasterModel.setOrderId("1");
        orderMasterModel.setBuyerName("zs");
        orderMasterModel.setBuyuePhone("123456");
        orderMasterModel.setBuyueAddress("中国");
        orderMasterModel.setBuyueOpenid("1974218313");
        orderMasterModel.setOrderAmount(new BigDecimal(0.02));
        orderMasterModel.setOrderStatus(0);
        orderMasterModel.setPayStatus(0);

    }


}