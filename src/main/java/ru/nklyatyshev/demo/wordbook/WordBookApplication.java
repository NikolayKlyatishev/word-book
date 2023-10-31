package ru.nklyatyshev.demo.wordbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class WordBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordBookApplication.class, args);
	}

}
