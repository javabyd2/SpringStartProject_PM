package com.sda.spring.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration

public class WebMvcConfig {
public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}
}
