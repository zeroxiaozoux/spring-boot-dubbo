package com.zero.dubbo.config;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.fastjson.JSON;
import com.dubbo.filter.JoinPoint;
import com.dubbo.filter.ProviderFilter;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zero
 * @date 2020/8/26-17:56
 */
@Component
@Slf4j
public class LogFilter implements ProviderFilter {

//    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
//        String className = invoker.getInterface().getName();
//        String methodName = invocation.getMethodName();
//        String arguments = JSON.toJSONString(invocation.getArguments());
//
//        try {
//            log.info("[{}-{}] 请求参数：param:{}", className, methodName, arguments);
//            Stopwatch stopwatch = Stopwatch.createStarted();
//            Result invoke = invoker.invoke(invocation);
//            stopwatch.stop();
//            String value = JSON.toJSONString(invoke.getValue());
//            if (invoke.hasException()) {
//                Throwable throwable = invoke.getException();
//                log.info("[{}-{}] success, 返回异常结果:{}, 消耗:{}", className, methodName, throwable.getMessage(), stopwatch.toString());
//            } else {
//                log.info("[{}-{}] success, 返回正常结果:{}, 消耗:{}", className, methodName, value, stopwatch.toString());
//            }

            // com.alibaba.dubbo.rpc.filter.ExceptionFilter 内置的统一异常配置 不需要自定义
//            if (invoke.hasException()) {
//                Throwable throwable = invoke.getException();
//                log.error("dubbo 服务业务异常", throwable);
//                return new RpcResult(ResultUtils.error(throwable.getMessage()));
//            }

//            Method signatureMethod = invoker.getInterface().getMethod(methodName, invocation.getParameterTypes());
//            Class targetClass = getTargetClass(invoker).getClass();
//            Method method = ClassUtils.getMostSpecificMethod(signatureMethod, targetClass);
//            log.info("signatureMethod:{},targetClass:{}, method:{}", signatureMethod, targetClass, method);
//            if (logResponse(method)) {
            // 打印返回值

//            } else {
//                不打印返回值
//                log.info("[{}-{}] success, 消耗:{}", className, methodName, stopwatch.toString());
            //int  i =  1/0 ; // 测试 Exception 异常   但是dubbo服务业务正常执行
//            return invoke;
//        } catch (Exception e) {
//            // return new RpcResult(ResultUtils.error());
//            throw new RpcException(e.getMessage());
//        }

    //}

    @Override
    public Result invoke(JoinPoint<?> point) throws RpcException {

        String className = point.getInterface().getName();
        String methodName = point.getMethodName();
        String arguments = JSON.toJSONString(point.getArguments());

        try {
            log.info("[{}-{}] 请求参数：param:{}", className, methodName, arguments);
            Stopwatch stopwatch = Stopwatch.createStarted();
            Result invoke = point.proceed();
            stopwatch.stop();
            String value = JSON.toJSONString(invoke.getValue());
            if (invoke.hasException()) {
                Throwable throwable = invoke.getException();
                log.info("[{}-{}] success, 返回异常结果:{}, 消耗:{}", className, methodName, throwable.getMessage(), stopwatch.toString());
            } else {
                log.info("[{}-{}] success, 返回正常结果:{}, 消耗:{}", className, methodName, value, stopwatch.toString());
            }

            return invoke;
        } catch (Exception e) {
            // return new RpcResult(ResultUtils.error());
            throw new RpcException(e.getMessage());
        }
    }

}
