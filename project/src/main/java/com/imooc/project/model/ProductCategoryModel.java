package com.imooc.project.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "Product_Category")
public class ProductCategoryModel {

    @Id
    @GeneratedValue
    private  Integer categoryId;

    private String categoryName;

    private Integer cateGoryType;

    private String createTime;

    private Timestamp updateTime;



}
