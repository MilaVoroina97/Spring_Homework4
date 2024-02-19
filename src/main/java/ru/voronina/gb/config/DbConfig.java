package ru.voronina.gb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "database")
public class DbConfig {


    private String findAllBooks;
    private String saveBook;
    private String getBookById;
    private String updateBook;
    private String deleteBook;
}
