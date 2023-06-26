package com.tkn.crudangular;

import com.tkn.crudangular.model.Course;
import com.tkn.crudangular.repository.ICourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CrudAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAngularApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("http://localhost:3000")
							.allowedMethods("*");
					//WebMvcConfigurer.super.addCorsMappings(registry);
			}
		};
	}

//	@Bean
//	CommandLineRunner initDatabase(ICourseRepository courseRepository) {
//		return args -> {
//			courseRepository.deleteAll();
//			Course c = new Course();
//			c.setName("Angular com Spring");
//			c.setCategory("front-end");
//			courseRepository.save(c);
//		};
//	}

}
