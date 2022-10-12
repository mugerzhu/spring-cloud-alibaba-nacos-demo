package org.example;


import org.example.api.SvcProviderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SvcConsumer {

    @Autowired
    private SvcProviderApi svcProviderApi;

    @Value("${svc.config.test.str}")
    private String helloStr;

    public static void main(String[] args) {
        SpringApplication.run(SvcConsumer.class, args);
    }

    /**
     * 调用svc-provider服务接口
     */
    @GetMapping
    public String invokeProvider() {
        Map<String, Object> stringObjectMap = svcProviderApi.echoHello();
        return (String) stringObjectMap.get("msg");
    }

    /**
     * 读取配置文件
     */
    @GetMapping("/read_config")
    public String readConfig() {
        Assert.notNull(helloStr, "read configuration file failed");
        return helloStr;
    }

}
