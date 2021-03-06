package com.imooc.project.service.impl;

import com.imooc.project.DTO.CartDTO;
import com.imooc.project.mapper.ProductInfoMapper;
import com.imooc.project.model.ProductInfoModel;
import com.imooc.project.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Autowired
    private ProductService productService;

    @Test
    public void getList() {
        Map<String,Object> map=new HashMap<>();
        ProductInfoModel productInfoModel = new ProductInfoModel();
        productInfoModel.setProductStatus(0);
        map.put("bean",productInfoModel);
        List<ProductInfoModel> list = productInfoMapper.getList(map);
        Assert.assertTrue(list.size()>0);

    }

    @Test
    public void getListCount() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void decreaseStock() {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setProductId("157875196366160022");
        cartDTO.setProductQuantity(1);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }
}