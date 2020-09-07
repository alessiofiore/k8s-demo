package com.example.k8s.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "custom")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomConfig {
    private String name = "Spring";
}
