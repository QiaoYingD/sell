package com.imooc.project.controller;

import com.imooc.project.DTO.CartDTO;
import com.imooc.project.VO.ResultVO;
import com.imooc.project.enums.ProductStatusEnum;
import com.imooc.project.execption.ProductExecption;
import com.imooc.project.model.ProductCategoryModel;
import com.imooc.project.model.ProductInfoModel;
import com.imooc.project.service.ProductCategoryService;
import com.imooc.project.service.ProductService;
import com.imooc.project.VO.ProductCategoryVO;
import com.imooc.project.VO.ProductInfoVo;
import com.imooc.project.utlis.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@RestController
@RequestMapping("product")
@Slf4j
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
    public ResultVO queryProductList() {
        //1.查询所有在架的商品
        Map<String, Object> map = new HashMap<>();
        ProductInfoModel productInfoModel = new ProductInfoModel();
        productInfoModel.setProductStatus(ProductStatusEnum.UP.getCode());
        map.put("bean", productInfoModel);
        List<ProductInfoModel> productInfoModelLists = productService.getList(map);

        //2.获取类目type列表
        List<Integer> categoryTypeList = productInfoModelLists.stream().map(ProductInfoModel::getCategoryType).collect(Collectors.toList());

        //3.从数据库查询类目
        List<ProductCategoryModel> productCategoryModels = productCategoryService.queryByCategoryType(categoryTypeList);
        List<ProductCategoryVO> productCategoryVos = new LinkedList<>();
        for (ProductCategoryModel categoryModel : productCategoryModels) {
            ProductCategoryVO productCategoryVo = new ProductCategoryVO();
            productCategoryVo.setCategoryName(categoryModel.getCategoryName());
            productCategoryVo.setCategoryType(categoryModel.getCategoryType());

            //类目对应商品，进行封装
            List<ProductInfoVo> productInfoVos = new LinkedList<>();
            for (ProductInfoModel productInfo : productInfoModelLists) {
                if (categoryModel.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVos.add(productInfoVo);
                }
            }
            productCategoryVo.setProductInfoVos(productInfoVos);
            productCategoryVos.add(productCategoryVo);
        }

        return ResultVOUtil.success(productCategoryVos);
    }

    /**
     * 获取商品列表（给订单服务用）
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoModel> listForOrder(@RequestBody List<String> productIdList){
        return productService.queryByProductId(productIdList);
    }

    /**
     * 扣库存（给订单服务用）
     */
    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
        productService.decreaseStock(cartDTOList);
    }
}
