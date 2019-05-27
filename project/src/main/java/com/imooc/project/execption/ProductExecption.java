package com.imooc.project.execption;


import com.imooc.project.enums.ResultEnum;

public class ProductExecption extends RuntimeException {

    private Integer code;

    public ProductExecption(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductExecption(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
