package myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "myapp.models") // Ajusta el paquete donde están tus entidades
public class MyWeb {
	public static void main(String[] args) {
		SpringApplication.run(MyWeb.class, args);
	}
}
