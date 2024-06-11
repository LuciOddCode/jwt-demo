package lk.cmg.jwt.jwtdemo.util;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Package : lk.me.loginBackend.util
 * Date :3/20/2024
 * Time : 12:19 PM
 * Project : centralized-cms-api
 */
@Configuration
public class JacksonUtil {

    @Bean
    public Jackson2ObjectMapperBuilder objectMapperBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.modulesToInstall(new JavaTimeModule());
        return builder;
    }
}
