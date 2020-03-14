package com.mybatis.generator.controller;

import com.mybatis.generator.common.CommonResponse;
import com.mybatis.generator.common.ErrorCodeEnum;
import com.mybatis.generator.consts.CommonConsts;
import com.mybatis.generator.consts.PathConsts;
import com.mybatis.generator.model.ItemInfo;
import com.mybatis.generator.service.ItemService;
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
 * @ClassName ItemController
 * @Author lzl
 * @Description 商品接口
 * @Date 2020/3/14 10:40
 * @Version 1.0
 **/
@Api(tags = "ItemController",description = "商品管理接口")
@RestController
@RequestMapping(value = PathConsts.ITEM_ROOT_PATH)
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    /**
     * @Author lzl
     * @Description 获取所有商品
     * @Date 11:00 2020/3/14
     * @Param []
     * @return com.mybatis.generator.common.CommonResponse
     **/
    @ApiOperation("获取所有商品")
    @GetMapping(PathConsts.GET_ALL)
    public CommonResponse ItemInfos()
    {
        LOGGER.info("start to search itemInfos");
        List<ItemInfo> itemInfos = itemService.findAllItem();
        if (null == itemInfos || itemInfos.size() == CommonConsts.ZERO_RESULT)
        {
            LOGGER.info("item size is zero");
            return CommonResponse.response(ErrorCodeEnum.NOT_EXISTS);
        }
        LOGGER.info("search itemInfos success,size:{}",itemInfos.size());
        return CommonResponse.success(itemInfos);
    }
}
