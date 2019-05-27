package com.imooc.project.service.impl;

import com.imooc.project.DTO.CartDTO;
import com.imooc.project.enums.ResultEnum;
import com.imooc.project.execption.ProductExecption;
import com.imooc.project.mapper.ProductInfoMapper;
import com.imooc.project.model.ProductInfoModel;
import com.imooc.project.service.ProductService;
import jdk.nashorn.internal.runtime.options.Option;
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

    @Override
    public List<ProductInfoModel> queryByProductId(List<String> productId) {
        return productInfoMapper.queryByProductId(productId);
    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOs) {
        for (CartDTO cartDTO : cartDTOs) {
            ProductInfoModel productInfoModel = new ProductInfoModel();
            productInfoModel.setProductId(cartDTO.getProductId());
            ProductInfoModel productInfo = productInfoMapper.getModel(productInfoModel);
            //判断商品是否存在
            if (productInfo == null) {
                throw new ProductExecption(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //判断库存是否足够
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new ProductExecption(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoMapper.update(productInfo);
        }
    }
}
