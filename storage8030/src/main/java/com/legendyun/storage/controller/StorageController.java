package com.legendyun.storage.controller;

import com.legendyun.common.entities.CommonResult;
import com.legendyun.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @title: StorageController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2023/12/27 11:48
 */

@RestController
@RequestMapping("storage")
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    @GetMapping("updateStorage/{productId}/{productNum}")
    public CommonResult<Integer> updateStorage(@PathVariable("productId") Integer productId,@PathVariable("productNum") Integer productNum){

        int result = storageService.updateStorage(productId,productNum);
        CommonResult<Integer> commonResult = null;
        if (result == 1) {
            commonResult = new CommonResult(200, "更新库存成功",result);
        }else if (result==-1){
            commonResult = new CommonResult(201, "更新库存失败-商品库存不足",result);
        }else if (result==0){
            commonResult = new CommonResult(201, "更新库存失败-未找到商品",result);
        }
        return commonResult;
    }
}
