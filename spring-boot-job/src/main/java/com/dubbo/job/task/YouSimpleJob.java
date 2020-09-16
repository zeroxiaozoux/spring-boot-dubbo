//package com.dubbo.job.task;
//
//import com.dangdang.ddframe.job.api.ShardingContext;
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
///**
// * @author zero
// * @date 2020/9/4-19:40
// *  对应 YouJobConfig 配置
// */
//@Slf4j
//@Component
//public class YouSimpleJob implements SimpleJob {
//
//    @Override
//    public void execute(ShardingContext shardingContext) {
//        log.debug("YouSimpleJob-Thread ID: {}, 作业分片总数: {}, 当前分片项:{} 当前参数: {},作业名称: {}.作业自定义参数: {}",
//                Thread.currentThread().getId(),
//                shardingContext.getShardingTotalCount(),
//                shardingContext.getShardingItem(),
//                shardingContext.getShardingParameter(),
//                shardingContext.getJobName(),
//                shardingContext.getJobParameter()
//        );
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        throw new RuntimeException("测试错误");
//    }
//}
