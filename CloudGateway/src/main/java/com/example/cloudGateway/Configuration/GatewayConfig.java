package com.example.cloudGateway.Configuration;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;

import com.example.cloudGateway.Service.ApiRouteLocatorImpl;
import com.example.cloudGateway.Service.RouteService;



@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteService routeService, RouteLocatorBuilder routeLocationBuilder) {
        return new ApiRouteLocatorImpl(routeLocationBuilder, routeService);
    } 
//    @Bean
//    public ServerCodecConfigurer serverCodecConfigurer() {
//       return ServerCodecConfigurer.create();
//    }
}