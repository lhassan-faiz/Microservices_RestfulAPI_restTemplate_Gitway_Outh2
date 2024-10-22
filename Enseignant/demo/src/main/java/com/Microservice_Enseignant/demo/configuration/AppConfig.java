package com.Microservice_Enseignant.demo.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RsaConfig.class)
public class AppConfig {
    // This class will now ensure RsaConfig is correctly bound
}
