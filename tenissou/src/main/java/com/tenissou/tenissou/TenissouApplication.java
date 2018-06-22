package com.tenissou.tenissou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TenissouApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenissouApplication.class, args);
	}
}
