//package com.dubbo.job.task;
//
//import com.dangdang.ddframe.job.api.ShardingContext;
//import com.dangdang.ddframe.job.api.simple.SimpleJob;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
///**
// * @author zero
// * @date 2020/9/4-19:25
// * 对应 MyJobConfig 配置
// */
//@Slf4j
//@Component
//public class MySimpleJob implements SimpleJob {
//
//    @Override
//    public void execute(ShardingContext shardingContext) {
//        log.debug("MySimpleJob-Thread ID: {}, 作业分片总数: {}, 当前分片项:{} 当前参数: {},作业名称: {}.作业自定义参数: {}",
//                Thread.currentThread().getId(),
//                shardingContext.getShardingTotalCount(),
//                shardingContext.getShardingItem(),
//                shardingContext.getShardingParameter(),
//                shardingContext.getJobName(),
//                shardingContext.getJobParameter()
//        );
//        // 分片大致如下：根据配置的分片参数执行相应的逻辑
//        switch (shardingContext.getShardingItem()) {
//            case 0:
//                // do something by sharding item 0
//                break;
//            case 1:
//                // do something by sharding item 1
//                break;
//            case 2:
//                // do something by sharding item 2
//                break;
//            // case n: ...
//        }
//    }
//
//}
