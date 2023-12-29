package com.legendyun.storage.service.impl;

import com.legendyun.common.entities.Storage;
import com.legendyun.storage.dao.StorageDao;
import com.legendyun.storage.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @title: StorageServiceImpl
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/12/27 11:17
 */

@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public int updateStorage(Integer productId, Integer productNum) {

        Storage storageOld = storageDao.getStorageByProductId(productId);

        if (storageOld !=null){
            if (storageOld.getResidue()>=productNum){
                storageOld.setUsed(storageOld.getUsed()+productNum);
                storageOld.setResidue(storageOld.getTotal()-storageOld.getUsed());
                int res = storageDao.updateStorage(storageOld);
                return res;
            }
            return -1;  //库存不足
        }

        return 0; //未找到商品
    }
}
