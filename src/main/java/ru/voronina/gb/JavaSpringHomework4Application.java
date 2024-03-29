package ru.voronina.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class JavaSpringHomework4Application {

    public static void main(String[] args) {

        SpringApplication.run(JavaSpringHomework4Application.class,args);
    }
}
