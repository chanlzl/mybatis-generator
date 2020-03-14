package com.mybatis.generator.service;

import com.mybatis.generator.model.ItemInfo;

import java.util.List;

public interface ItemService {

    List<ItemInfo> findAllItem();

    int deleteItem(Integer id);

    int insertItem(ItemInfo record);

    int updateItem(ItemInfo record);

    List<ItemInfo> listItemInfo(int pageNum, int pageSize);

    ItemInfo getItem(Integer id);
}
