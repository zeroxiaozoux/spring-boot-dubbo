package com.dubbo.job.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.zero.api.dto.UserDto;
import com.zero.api.job.StatService;
import com.zero.api.ret.UserRet;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zero
 * @date 2020/9/4-19:39
 */
@Slf4j
@Component
public class PropertiesSimpleJob implements SimpleJob {

    @Autowired
    private StatService statService;

    @Override
    public void execute(ShardingContext shardingContext) {
        log.debug("PropertiesSimpleJob-Thread ID: {}, 作业分片总数: {}, 当前分片项:{} 当前参数: {},作业名称: {}.作业自定义参数: {}",
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter()
        );


        // 分片中有一个超时未处理完，整个任务都会跳到下个时间点执行

        // 分片大致如下：根据配置的分片参数执行相应的逻辑
        switch (shardingContext.getShardingItem()) {
            case 0:
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
               statService.countUser(shardingContext.getShardingParameter());
               log.debug("当前分片项 0 执行任务...............");
                break;
            case 1:
//                try {
//                    Thread.sleep(80000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                UserDto userDto = new UserDto();
                userDto.setId(Long.parseLong(shardingContext.getShardingParameter()));
                UserRet ret = statService.getUser(userDto);
                log.debug("当前分片项 1 执行任务:{}",ret.toString());
                break;
            case 2:
//                try {
//                    Thread.sleep(30000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
               // statService.countUser();
                log.debug("当前分片项 2 执行任务.............");
                break;
            // case n: ...
        }
    }
}
