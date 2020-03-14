package com.mybatis.generator.service.impl;

import com.github.pagehelper.PageHelper;
import com.mybatis.generator.mapper.OrderRecordMapper;
import com.mybatis.generator.model.OrderRecord;
import com.mybatis.generator.model.OrderRecordExample;
import com.mybatis.generator.service.OrderRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lzl
 * @Description 订单业务处理
 * @Date 10:15 2020/3/14
 * @Param
 * @return
 **/
@Service
public class OrderRecordImpl implements OrderRecordService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderRecordService.class);
    @Autowired
    private OrderRecordMapper recordMapper;

    @Override
    public List<OrderRecord> findAllOrder() {
        return recordMapper.selectByExample(new OrderRecordExample());
    }

    @Override
    public int deleteOrder(Integer id) {
        return recordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertOrder(OrderRecord order) {
        return recordMapper.insertSelective(order);
    }

    @Override
    public int updateOrder(OrderRecord order) {
        return recordMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public List<OrderRecord> listOrder(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return recordMapper.selectByExample(new OrderRecordExample());
    }

    @Override
    public OrderRecord getOrder(Integer id) {
        return recordMapper.selectByPrimaryKey(id);
    }
}
