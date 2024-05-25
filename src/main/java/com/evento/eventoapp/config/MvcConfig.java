package com.evento.eventoapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/static/**") // O padrão do URL para recursos estáticos
            .addResourceLocations("classpath:/static/"); // O diretório base onde os recursos estáticos estão localizados
    }
}
