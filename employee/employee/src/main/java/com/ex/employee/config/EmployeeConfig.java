package com.ex.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class EmployeeConfig {
 @Bean
 public RestTemplate getRestClient() {

  RestTemplate getRestClient= new RestTemplate();

  return getRestClient;

 }
}
