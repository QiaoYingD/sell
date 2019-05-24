package com.imooc.project.service.impl;

import com.imooc.project.mapper.ProductCategoryMapper;
import com.imooc.project.model.ProductCategoryModel;
import com.imooc.project.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategoryModel> getList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int getListCount(ProductCategoryModel productCategory) {
        return 0;
    }

    @Override
    public int insert(ProductCategoryModel productCategory) {
        return 0;
    }

    @Override
    public int update(ProductCategoryModel productCategory) {
        return 0;
    }

    @Override
    public int delete(ProductCategoryModel productCategory) {
        return 0;
    }

    @Override
    public ProductCategoryModel getModel(ProductCategoryModel productCategory) {
        return null;
    }

    @Override
    public List<ProductCategoryModel> queryByCategoryType() {
        return productCategoryMapper.queryByCategoryType();
    }
}
