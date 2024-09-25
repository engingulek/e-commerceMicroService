package com.example.api_gateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {
    @Bean
    public RouterFunction<ServerResponse> categoryServiceRoute() {
        return  GatewayRouterFunctions.route("category_microservice")
        .route(RequestPredicates.path("/api/category/**"), HandlerFunctions.http("http://localhost:8081"))
        .build();
    }

    @Bean
    public RouterFunction<ServerResponse> productServiceRoute() {
        return  GatewayRouterFunctions.route("product_microservice")
        .route(RequestPredicates.path("/api/product/**"), HandlerFunctions.http("http://localhost:8082"))
        .build();
    }

    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute() {
        return  GatewayRouterFunctions.route("inventory-microservice")
        .route(RequestPredicates.path("/api/inventory/**"), HandlerFunctions.http("http://localhost:8083"))
        .build();
    }

    @Bean
    public RouterFunction<ServerResponse> userServiceRoute() {
        return  GatewayRouterFunctions.route("user_microservice")
        .route(RequestPredicates.path("/api/user/**"), HandlerFunctions.http("http://localhost:8084"))
        .build();
    }


    @Bean
    public RouterFunction<ServerResponse> cartServiceRoute() {
        return  GatewayRouterFunctions.route("cart_microservice")
        .route(RequestPredicates.path("/api/cart/**"), HandlerFunctions.http("http://localhost:8085"))
        .build();
    }


}
