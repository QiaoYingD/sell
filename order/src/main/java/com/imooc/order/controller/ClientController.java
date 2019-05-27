package com.imooc.order.controller;

import com.google.gson.Gson;
import com.imooc.order.client.ProductClient;
import com.imooc.order.dto.CartDTO;
import com.imooc.order.model.ProductInfoModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 获取product服务的controlelr接口的实例
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    /**
     * 使用 feign 调用product服务
     *
     * @return
     */
    @GetMapping("/getProductMsg2")
    public String productMsg2() {
        String response = productClient.ProductMsg();
        log.info("response={}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfoModel> response = productClient.listForOrder(Arrays.asList("157875196366160022", "164103465734242707"));
        log.info("response={}",response);
        return new Gson().toJson(response);
    }

    @GetMapping("/decreaseStock")
    public void decreaseStock(){
        CartDTO cartDTO = new CartDTO();
        cartDTO.setProductId("157875196366160022");
        cartDTO.setProductQuantity(1);
        productClient.decreaseStock(Arrays.asList(cartDTO));
    }

    //第二种方式调用
    //@Autowired
    //private LoadBalancerClient loadBalancerClient;

    //第三种方式调用
    //@Autowired
    //private RestTemplate restTemplate;

    /**
     * 使用 RestTemplate 调用produc服务
     *
     * @return
     */
    //@GetMapping("/getProductMsg1")
    //public String getProductMsg1() {

    //第一种调用方式 （直接使用RestTempLATE,url写死）
    //RestTemplate restTemplate = new RestTemplate();
    //String response = restTemplate.getForObject("http://localhost:8090/msg", String.class);

    //第二种调用方式 （利用LadBalancerClient通过应用名获取url，然后在使用RestTemplate）
    //RestTemplate restTemplate = new RestTemplate();
    //ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
    //String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort() + "/msg");
    //String response = restTemplate.getForObject(url, String.class);

    //第三种调用方式（利用@LoadBalanced,可在restTemplate里使用应用名）
    //String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);

    //log.info("response={}", response);
    //return response;
    //}

}
