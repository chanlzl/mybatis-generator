package com.mybatis.generator.common;

/**
 * @ClassName CommonResponse
 * @Author lzl
 * @Description 统一返回结果响应
 * @Date 2020/3/14 10:32
 * @Version 1.0
 **/
public class CommonResponse<T> {

    private Integer code;

    private String message;

    private T result;



    public CommonResponse(ErrorCodeEnum codeEnum, T result) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
        this.result = result;
    }

    public CommonResponse(ErrorCodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.message = codeEnum.getMessage();
    }

    /**
     * @Author lzl
     * @Description 成功响应
     * @Date 10:37 2020/3/14
     * @Param [result]
     * @return com.mybatis.generator.common.CommonResponse
     **/
    public static <T> CommonResponse<T> success(T result)
    {
        return new CommonResponse<T>(ErrorCodeEnum.SUCCESS,result);
    }

    /**
     * @Author lzl
     * @Description 失败响应结果
     * @Date 10:39 2020/3/14
     * @Param []
     * @return com.mybatis.generator.common.CommonResponse
     **/
    public static CommonResponse fail()
    {
        return new CommonResponse(ErrorCodeEnum.FAILED);
    }

    public static CommonResponse response(ErrorCodeEnum codeEnum)
    {
        return new CommonResponse(codeEnum);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
