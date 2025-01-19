package com.goxmore.shoppingcart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {

  @Bean
  public CorsFilter corsFilter() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.addAllowedOrigin("http://localhost:3000"); // Allow specific origin
    corsConfig.addAllowedMethod("*"); // Allow all HTTP methods
    corsConfig.addAllowedHeader("*"); // Allow all headers
    corsConfig.setAllowCredentials(true); // Allow credentials (cookies, etc.)

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig); // Apply to all endpoints
    return new CorsFilter(source);
  }

}
