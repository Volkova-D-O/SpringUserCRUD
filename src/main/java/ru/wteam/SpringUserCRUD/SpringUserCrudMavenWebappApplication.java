package ru.wteam.SpringUserCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = "ru.wteam")
public class SpringUserCrudMavenWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUserCrudMavenWebappApplication.class, args);
	}

}
