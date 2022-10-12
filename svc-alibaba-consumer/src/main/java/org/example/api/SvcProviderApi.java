package org.example.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @author dehong.zhu
 */

@FeignClient(name = "svc-provider")
public interface SvcProviderApi {

    @GetMapping
    Map<String, Object> echoHello();
}
