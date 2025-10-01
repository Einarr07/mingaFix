package com.mingaFix.mingaFix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MingaFixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MingaFixApplication.class, args);
    }

}
