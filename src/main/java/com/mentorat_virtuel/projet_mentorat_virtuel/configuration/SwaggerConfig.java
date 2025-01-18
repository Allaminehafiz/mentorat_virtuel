package com.mentorat_virtuel.projet_mentorat_virtuel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestion de l'École")
                        .version("1.0")
                        .description("Documentation de l'API pour la gestion des données liées à l'école et au mentorat virtuel"));
    }
}

