package com.practise.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class JournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalApplication.class, args);
	}

    @Bean
    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

//PlatformTransactionManager (It is an interface)
//MongoTransactionManager(this will implement PlatformTransactionManager)
//MongoDatabaseFactory(provides db connection)
//To enable transaction management we need to add @EnableTransactionManagement in the main class
//To enable scheduling we need to add @EnableScheduling in the main class
