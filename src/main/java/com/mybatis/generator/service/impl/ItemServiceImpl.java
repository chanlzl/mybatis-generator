package com.mybatis.generator.service.impl;

import com.github.pagehelper.PageHelper;
import com.mybatis.generator.mapper.ItemInfoMapper;
import com.mybatis.generator.model.ItemInfo;
import com.mybatis.generator.model.ItemInfoExample;
import com.mybatis.generator.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author lzl
 * @Description 商品处理
 * @Date 10:16 2020/3/14
 * @Param
 * @return
 **/
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemInfoMapper infoMapper;

    @Override
    public List<ItemInfo> findAllItem() {
        return infoMapper.selectByExample(new ItemInfoExample());
    }

    @Override
    public int deleteItem(Integer id) {
        return infoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertItem(ItemInfo record) {
        return infoMapper.insertSelective(record);
    }

    @Override
    public int updateItem(ItemInfo record) {
        return infoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<ItemInfo> listItemInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return infoMapper.selectByExample(new ItemInfoExample());
    }

    @Override
    public ItemInfo getItem(Integer id) {
        return infoMapper.selectByPrimaryKey(id);
    }
}
