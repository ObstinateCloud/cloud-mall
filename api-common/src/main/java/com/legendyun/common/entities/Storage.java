package com.legendyun.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @title: Storage
 * @description: 库存
 * @auther: zhangjianyun
 * @date: 2023/12/27 11:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage implements Serializable {

    private Long id;

    private int productId;

    private int total;

    private int used;

    private int residue;
}
