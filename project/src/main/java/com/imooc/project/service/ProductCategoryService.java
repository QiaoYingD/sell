package com.imooc.project.service;

import com.imooc.project.model.ProductCategoryModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface ProductCategoryService {


    // 列表查询方法
    // map中只有2个对象：实体类bean，分页page
    public List<ProductCategoryModel> getList(Map<String, Object> map);

    // 查询总数方法
    public int getListCount(ProductCategoryModel productCategory);

    // 增加方法
    public int insert(ProductCategoryModel productCategory);

    // 修改方法
    public int update(ProductCategoryModel productCategory);

    // 删除方法
    public int delete(ProductCategoryModel productCategory);

    // 查询单个对象
    public ProductCategoryModel getModel(ProductCategoryModel productCategory);

    List<ProductCategoryModel> queryByCategoryType(List<Integer> categoryTypeList);

}
