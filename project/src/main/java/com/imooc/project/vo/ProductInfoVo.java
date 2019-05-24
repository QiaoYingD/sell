package com.imooc.project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductInfoVo {

    @JsonProperty("id")
    private Integer productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private String productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;



}
