//package com.phototraveler.phototraveler;
//
//import com.phototraveler.phototraveler.Model.Quest;
//import com.phototraveler.phototraveler.Model.Status;
//import com.phototraveler.phototraveler.Model.User;
//import com.phototraveler.phototraveler.Repository.QuestRepository;
//import com.phototraveler.phototraveler.Repository.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//class X {
//
//	private static final Logger log = LoggerFactory.getLogger(X.class);
//
//	@Bean
//    CommandLineRunner initDatabase(UserRepository userRepository, QuestRepository questRepository) {
//
//		return args -> {
//			userRepository.save(new User("Frodąęłóo","XD","JP2GMD","l","m"));
//			userRepository.save(new User("Frodąęłóo","XD","JP2GMD","l","l"));
//			userRepository.save(new User("Frodąęłóo","XD","JP2GMD","l","l"));
//			userRepository.save(new User("Frodąęłóo","XDDDD","JP2GMD","l","l"));
//			userRepository.save(new User("Frodąęłóo","XD","JP2GMD","l","l"));
//
//			userRepository.findAll().forEach(user -> log.info("Preloaded " + user));
//
//			questRepository.save(new Quest("xD",  "x", Status.IN_PROGRESS, userRepository.findById(1L)));
//
//			questRepository.findAll().forEach(quest -> {
//				log.info("preloaded" + quest);
//			});
//
//		};
//	}
//
//
//}
