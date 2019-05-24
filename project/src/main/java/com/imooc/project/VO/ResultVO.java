package com.imooc.project.VO;

import lombok.Data;

/**
 * http消息返回的最外层对象
 * @param <T>
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;

}
