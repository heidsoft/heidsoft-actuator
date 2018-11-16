package com.heidsoft.heidsoftactuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @program: heidsoft-actuator
 * @description: 健康检查
 * @author: heidsoft
 * @create: 2018-11-16 13:52
 **/
@Component
public class HeidsoftHealthCheck implements HealthIndicator{
    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down()
                    .withDetail("status", errorCode)
                    .withDetail("message", "服务故障")
                    .build();
        }
        return Health.up().build();
    }

    private int check(){
        // 对监控对象的检测操作
        return HttpStatus.NOT_FOUND.value();
    }

}
