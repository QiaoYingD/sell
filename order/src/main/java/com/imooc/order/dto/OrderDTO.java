package com.imooc.order.dto;

import com.imooc.order.model.OrderDetailModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDTO {

    /**
     * 订单详细ID
     */
    private String detailId;

    /**
     * 订单Id
     */
    private String orderId;

    /**
     * 商品id
     */
    private String productId;

    /**
     * 卖家名称
     */
    private String buyerName;

    /**
     * 买家手机号
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信Openid
     */
    private String buyerOpenid;

    /**
     * 订单详情
     */
    private List<OrderDetailModel> orderDetailModels;


}
