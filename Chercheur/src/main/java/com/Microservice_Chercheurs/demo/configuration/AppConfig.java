package com.Microservice_Chercheurs.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Configuration
@EnableConfigurationProperties(RsaConfig.class)
public class AppConfig {
    // This class will now ensure RsaConfig is correctly bound
}
