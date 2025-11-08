package ru.wteam.SpringUserCRUD;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

import io.github.cdimascio.dotenv.Dotenv;

@EnableKafka
@SpringBootApplication(scanBasePackages = "ru.wteam")
//@EnableDiscoveryClient
public class SpringUserCrudMavenWebappApplication {
	Dotenv dotenv = Dotenv.load();
//	Dotenv dotenv = Dotenv.configure().directory("app/.env").load();




		public static void main(String[] args) {
		SpringApplication.run(SpringUserCrudMavenWebappApplication.class, args);
	}

}
