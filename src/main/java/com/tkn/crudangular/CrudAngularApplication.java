package com.tkn.crudangular;

import com.tkn.crudangular.model.Course;
import com.tkn.crudangular.repository.ICourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudAngularApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ICourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();
			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("front-end");
			courseRepository.save(c);
		};
	}

}