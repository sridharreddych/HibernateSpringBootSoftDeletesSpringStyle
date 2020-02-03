package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            bookstoreService.testSoftDeletes();
        };
    }
}

/*
 * 
 * 
 * 
 * How To Implement Soft Deletes Via SoftDeleteRepository In Spring Boot Application

Note: Spring Data built-in support for soft deletes is discussed in DATAJPA-307.

Description: This application is an example of implementing soft deletes in Spring Data style via a repository named, SoftDeleteRepository.

Key points:

define an abstract class, BaseEntity, annotated with @MappedSuperclass
in BaseEntity define a flag-field named deleted (default this field to false or in other words, not deleted)
every entity that wants to take advantage of soft deletes should extend the BaseEntity classs
write a @NoRepositoryBean named SoftDeleteRepository and extend JpaRepository
override and implement the needed methods that provide the logic for soft deletes (check out the source code)
repositories of entities should extend SoftDeleteRepository
 * 
 */
