package com.mybatis.generator.common;

/**
 * @Author lzl
 * @Description 错误码接口
 * @Date 10:17 2020/3/14
 * @Param
 * @return
 **/
public interface IErrorCode {

    Integer getCode();

    String getMessage();
}
