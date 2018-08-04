package com.storemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.storemanager.repo.StoreManagerRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
@SpringBootApplication
@EnableSwagger2
public class DepartmentStoreManagerApplication {

    @Autowired
    StoreManagerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DepartmentStoreManagerApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.storemanager.controller")) // Generate API of EndPoints
                                                                                          // which is available inside
                                                                                          // defined package
                .paths(PathSelectors.any()) // for all EndPoints
                .build(); // create object
    }
}
