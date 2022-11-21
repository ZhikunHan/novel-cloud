package com.hantiv.novel.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author Zhikun Han
 * @Date Created in 20:48 2022/11/20
 * @Description:
 */
@Data
@Component
@ConfigurationProperties(prefix = "http.proxy")
@Deprecated
public class HttpProxyProperties {

    private Boolean enabled;

    private String ip;

    private Integer port;

}
