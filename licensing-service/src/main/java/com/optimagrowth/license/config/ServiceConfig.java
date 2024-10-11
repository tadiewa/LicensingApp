/**
 * @author : tadiewa
 * date: 9/23/2024
 */


package com.optimagrowth.license.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "example")
@Component
public class ServiceConfig {
    private String property;
    public String getProperty(){
        return property;
    }
}
