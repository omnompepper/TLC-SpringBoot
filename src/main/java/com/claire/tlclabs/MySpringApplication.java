package com.claire.tlclabs;

import com.claire.tlclabs.repos.AccountRepository;
import com.claire.tlclabs.services.AccountService;
import com.claire.tlclabs.services.ExampleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

@SpringBootApplication
public class MySpringApplication {

    private static final Logger logger = LoggerFactory.getLogger(MySpringApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MySpringApplication.class, args);
        System.out.println("Number of beans:" + context.getBeanDefinitionCount());

        AccountRepository repo = context.getBean(AccountRepository.class);

        repo.getAllAccounts()
                .stream().forEach(a -> System.out.println(a));

        repo.getAllAccounts()
                .stream().forEach(a -> logger.info(a.toString()));
        //logger.info("test");
    }
}