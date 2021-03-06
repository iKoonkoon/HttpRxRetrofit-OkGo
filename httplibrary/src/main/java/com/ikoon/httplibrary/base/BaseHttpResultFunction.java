package com.ikoon.httplibrary.base;


import com.ikoon.httplibrary.exception.ServerException;

import io.reactivex.functions.Function;

import static com.ikoon.httplibrary.config.Constants.HTTP_SUCCESS;

/**
 * @author MrKong
 * @date 18/4/21
 * @Description 返回结果统一处理类
 */

public class BaseHttpResultFunction<T> implements Function<BaseResponseEntity<T>, T>
{
    
    @Override
    public T apply(BaseResponseEntity<T> baseResponseEntity)
    {
        if (baseResponseEntity.getCode() == HTTP_SUCCESS)
        {
            // 请求成功 返回数据
            return baseResponseEntity.getData();
        } else
        {
            // 请求失败 抛异常
            throw new ServerException(baseResponseEntity.getCode(), baseResponseEntity.getMessage());
        }
    }
}
