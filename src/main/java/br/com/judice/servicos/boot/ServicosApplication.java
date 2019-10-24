package br.com.judice.servicos.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.judice.servicos"})
public class ServicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicosApplication.class, args);
	}
}