package com.mybatis.generator.controller;

import com.mybatis.generator.common.CommonResponse;
import com.mybatis.generator.common.ErrorCodeEnum;
import com.mybatis.generator.consts.CommonConsts;
import com.mybatis.generator.consts.PathConsts;
import com.mybatis.generator.model.OrderRecord;
import com.mybatis.generator.service.OrderRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName OrderController
 * @Author lzl
 * @Description 订单接口
 * @Date 2020/3/14 11:27
 * @Version 1.0
 **/
@Api(tags = "OrderController",description = "订单管理接口")
@RestController
@RequestMapping(value = PathConsts.ORDER_ROOT_PATH)
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);


    @Autowired
    private OrderRecordService recordService;

    /**
     * @Author lzl
     * @Description 获取所有订单信息
     * @Date 11:28 2020/3/14
     * @Param []
     * @return com.mybatis.generator.common.CommonResponse
     **/
    @ApiOperation("获取所有订单信息")
    @GetMapping(PathConsts.GET_ALL)
    public CommonResponse orderInfos()
    {
        LOGGER.info("start to search orderInfos");
        List<OrderRecord> orderRecords = recordService.findAllOrder();
        if (null == orderRecords || orderRecords.size() == CommonConsts.ZERO_RESULT)
        {
            LOGGER.info("orderInfos size is zero");
            return CommonResponse.response(ErrorCodeEnum.NOT_EXISTS);
        }
        LOGGER.info("search orderInfos success,size:{}",orderRecords.size());
        return CommonResponse.success(orderRecords);
    }

}
