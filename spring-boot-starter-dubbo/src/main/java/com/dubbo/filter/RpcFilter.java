package com.dubbo.filter;

import com.alibaba.dubbo.rpc.Result;

public interface RpcFilter{

	Result invoke(JoinPoint<?> point);
}