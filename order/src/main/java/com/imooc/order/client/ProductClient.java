package com.imooc.order.client;

import com.imooc.order.dto.CartDTO;
import com.imooc.order.model.ProductInfoModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String ProductMsg();

    @PostMapping("/product/listForOrder")
    public List<ProductInfoModel> listForOrder(@RequestBody  List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList);

}
