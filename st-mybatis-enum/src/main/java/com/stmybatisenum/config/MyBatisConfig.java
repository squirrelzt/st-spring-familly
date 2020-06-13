package com.stmybatisenum.config;

import com.stmybatisenum.enums.GradeEnum;
import com.stmybatisenum.handler.ZipCodeEnumHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class MyBatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {

            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                log.info("---------------------");
                //在这里可以对 configuration 进行多种操作
                TypeHandlerRegistry registry = configuration.getTypeHandlerRegistry();
                registry.register(ZipCodeEnumHandler.class);
                registry.register(GradeEnum.class, EnumOrdinalTypeHandler.class);
            }
        };
    }
}
