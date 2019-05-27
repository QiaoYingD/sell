package com.imooc.project.service;

import com.imooc.project.DTO.CartDTO;
import com.imooc.project.model.ProductInfoModel;

import java.util.List;
import java.util.Map;

public interface ProductService {

    // 列表查询方法
    // map中只有2个对象：实体类bean，分页page
    public List<ProductInfoModel> getList(Map<String, Object> map);

    // 查询总数方法
    public int getListCount(ProductInfoModel productInfo);

    // 增加方法
    public int insert( ProductInfoModel productInfo);

    // 修改方法
    public int update( ProductInfoModel productInfo);

    // 删除方法
    public int delete( ProductInfoModel productInfo);

    // 查询单个对象
    public ProductInfoModel getModel(ProductInfoModel productInfo);

    //列表查询方法
    List<ProductInfoModel> queryByProductId(List<String> productId);

    /**
     *  扣库存
     * @param cartDTOS
     */
    void decreaseStock(List<CartDTO> cartDTOS);



}
