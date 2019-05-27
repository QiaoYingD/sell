package com.imooc.order.model;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ProductInfoModel {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;

    private String createTime;

    private Timestamp updateTime;



}
