package com.example;

import com.example.viewhelper.MyDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EntityScan(basePackages = {"com.example.domain"})
@EnableJpaRepositories(basePackages = {"com.example.domain"})
@EnableTransactionManagement(proxyTargetClass = true)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	//THYMELEAF Utility Object
	@Bean
	MyDialect myDialect(){
		return new MyDialect();
	}
}
