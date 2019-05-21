package com.imooc.project.service.impl;

import com.imooc.project.mapper.ProductInfoMapper;
import com.imooc.project.model.ProductInfoModel;
import com.imooc.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoMapper productInfoMapper;


    @Override
    public List<ProductInfoModel> getList(Map<String, Object> map) {
        return productInfoMapper.getList(map);
    }

    @Override
    public int getListCount(ProductInfoModel productInfo) {
        return productInfoMapper.getListCount(productInfo);
    }

    @Override
    public int insert(ProductInfoModel productInfo) {
        return productInfoMapper.insert(productInfo);
    }

    @Override
    public int update(ProductInfoModel productInfo) {
        return productInfoMapper.update(productInfo);
    }

    @Override
    public int delete(ProductInfoModel productInfo) {
        return productInfoMapper.delete(productInfo);
    }

    @Override
    public ProductInfoModel getModel(ProductInfoModel productInfo) {
        return productInfoMapper.getModel(productInfo);
    }
}
