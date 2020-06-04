package com.phototraveler.phototraveler;

import com.phototraveler.phototraveler.Model.User;
import com.phototraveler.phototraveler.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {

		return args -> {
			userRepository.save(new User("Frodo"));

			userRepository.findAll().forEach(employee -> log.info("Preloaded " + employee));

			
		};
	}
}
