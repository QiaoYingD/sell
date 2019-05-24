package com.imooc.project.mapper;


import com.imooc.project.ProductApplicationTests;
import com.imooc.project.model.ProductCategoryModel;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductCategoryMapperTest extends ProductApplicationTests {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Test
    public void findByCategoryType() {
        List<ProductCategoryModel> list = productCategoryMapper.queryByCategoryType();
        Assert.assertTrue(list.size()>0);

    }
}