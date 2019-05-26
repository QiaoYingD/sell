package com.imooc.order.mapper;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.model.OrderDetailModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@Component
public class OrderDetailMapperTest extends OrderApplicationTests {


    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Test
    public void save (){


        OrderDetailModel orderDetailModel = new OrderDetailModel();
        orderDetailModel.setDetailId("1");
        orderDetailModel.setOrderId("1");
        orderDetailModel.setProductId("1");
        orderDetailModel.setProductName("1");
        orderDetailModel.setProductPrice(new BigDecimal(1));
        orderDetailModel.setProductQuantity("1");
        orderDetailModel.setProductIcon("1.com");
        orderDetailModel.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        orderDetailMapper.save(orderDetailModel);
    }

}