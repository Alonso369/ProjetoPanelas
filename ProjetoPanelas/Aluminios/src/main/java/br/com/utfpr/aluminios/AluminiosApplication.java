package br.com.utfpr.aluminios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.utfpr.aluminios", "br.com.utfpr.service"})
public class AluminiosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluminiosApplication.class, args);
	}

}
