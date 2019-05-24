package com.imooc.project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class ProductCategoryVo {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private String categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> productInfoVos;

}
