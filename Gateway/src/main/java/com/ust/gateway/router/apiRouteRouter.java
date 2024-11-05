package com.ust.gateway.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ust.gateway.handler.ApiRouteHandler;

@Configuration
public class apiRouteRouter {
    @Bean
    public RouterFunction<ServerResponse> route(ApiRouteHandler apiRouteHandler) {
        return RouterFunctions.route(POST("/routes")
                        .and(accept(MediaType.APPLICATION_JSON)), apiRouteHandler::create)
                .andRoute(GET("/routes/:routeId")
                        .and(accept(MediaType.APPLICATION_JSON)), apiRouteHandler::getById)
                .andRoute(GET("/routes/refresh-routes")
                        .and(accept(MediaType.APPLICATION_JSON)), apiRouteHandler::refreshRoutes);
    }
}