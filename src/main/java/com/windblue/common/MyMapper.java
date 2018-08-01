package com.windblue.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: wilburli
 * @Description:
 * @Date: Created by sh on 2018-07-27.
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
    //TODO 该接口不能不扫描到，否则会报错
}
