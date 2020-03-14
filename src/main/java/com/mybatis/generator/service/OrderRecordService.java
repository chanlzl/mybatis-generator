package com.mybatis.generator.service;

import com.mybatis.generator.model.ItemInfo;
import com.mybatis.generator.model.OrderRecord;

import java.util.List;

public interface OrderRecordService{

    List<OrderRecord> findAllOrder();

    int deleteOrder(Integer id);

    int insertOrder(OrderRecord order);

    int updateOrder(OrderRecord order);

    List<OrderRecord> listOrder(int pageNum, int pageSize);

    OrderRecord getOrder(Integer id);
}
