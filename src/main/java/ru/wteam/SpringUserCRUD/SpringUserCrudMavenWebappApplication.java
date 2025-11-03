package ru.wteam.SpringUserCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;


@EnableKafka
@SpringBootApplication(scanBasePackages = "ru.wteam")
@EnableDiscoveryClient
public class SpringUserCrudMavenWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUserCrudMavenWebappApplication.class, args);
	}

}
