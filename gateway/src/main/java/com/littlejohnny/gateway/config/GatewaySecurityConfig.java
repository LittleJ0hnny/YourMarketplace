package com.littlejohnny.gateway.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GatewaySecurityConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        http
                .authorizeRequests()
                .antMatchers("/authservice/oauth/token", "/actuator/**", "/discovery/**", "/eureka/**", "/configserver/**", "/image-service/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public RequestInterceptor getUserFeignClientInterceptor() {
        return new FeignClientInterceptor();
    }
}

