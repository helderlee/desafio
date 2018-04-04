package pro.helderlee.desafio;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DesafioApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		// SpringApplication.run(DesafioApplication.class, args);
		new DesafioApplication().configure(new SpringApplicationBuilder(DesafioApplication.class)).run(args);
	}
}
