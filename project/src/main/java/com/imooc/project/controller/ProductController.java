package com.imooc.project.controller;

import com.imooc.project.enums.ProductStatusEnum;
import com.imooc.project.model.ProductCategoryModel;
import com.imooc.project.model.ProductInfoModel;
import com.imooc.project.service.ProductCategoryService;
import com.imooc.project.service.ProductService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("product")
public class ProductController {


    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService productService;


    /**
     * 1.查询所有在架的商品
     * 2.获取类目type列表
     * 3.查询类目
     * 4.构造数据
     */
    @GetMapping("/queryProductList")
    public void queryProductList() {
        Map<String, Object> map = new HashMap<>();
        ProductInfoModel productInfoModel = new ProductInfoModel();
        productInfoModel.setProductStatus(ProductStatusEnum.UP.getCode());
        map.put("bean",productInfoModel);
        List<ProductInfoModel> productInfoModelLists = productService.getList(map);
        List<Integer> categoryTypeList = productInfoModelLists.stream().map(ProductInfoModel::getCategoryType).collect(Collectors.toList());


        List<ProductCategoryModel> productCategoryModels = productCategoryService.queryByCategoryType();

    }


}
