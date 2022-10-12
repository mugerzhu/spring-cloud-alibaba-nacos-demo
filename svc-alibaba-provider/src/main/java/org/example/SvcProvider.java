package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class SvcProvider {

    public static void main( String[] args ) {
        SpringApplication.run(SvcProvider.class, args);
    }

    @GetMapping
    public Map<String, Object> echoHello() {
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "hello world!");
        return result;
    }
}
