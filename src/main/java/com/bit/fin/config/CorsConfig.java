package com.bit.fin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addAllowedMethod("*");
        config.addAllowedOriginPattern("*");
        source.registerCorsConfiguration("/api/**", config);
        source.registerCorsConfiguration("/moim/**", config);
        source.registerCorsConfiguration("/test/**", config);
        source.registerCorsConfiguration("/**", config);
        
        source.registerCorsConfiguration("/challenge/**", config);
        return new CorsFilter(source);
    }
}
