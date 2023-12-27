package com.legendyun.storage.dao;

import com.legendyun.common.entities.Storage;
import org.apache.ibatis.annotations.Mapper;


/**
 * @title: PaymentDao
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/10/8 15:14
 */

@Mapper
public interface StorageDao{


    Storage getStorageByProductId(Integer productId);

    int updateStorage(Storage storage);
}
