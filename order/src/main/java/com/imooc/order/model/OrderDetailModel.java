package com.imooc.order.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "order_dateil")
public class OrderDetailModel {

    /**
     * 订单详细ID
     */
    @Id
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
     * 商品名称
     */
    private String productName;

    /**
     * 商品单价
     */
    private String productPrice;

    /**
     * 商品数量
     */
    private String productQuantity;

    /**
     * 商品图片
     */
    private String productIcon;

    /**
     * 创建时间
     */
    private String createTime;


}
