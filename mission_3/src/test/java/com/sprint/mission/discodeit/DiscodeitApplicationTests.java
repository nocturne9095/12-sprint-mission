package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.repository.UserRepository;
import com.sprint.mission.discodeit.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest (classes = JavaApplication.class,
				properties = "discodeit.repository.type=jcf")
class DiscodeitApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
		System.out.println( userRepository.getClass().getSimpleName());
		assertThat(userRepository).isNotNull();
	}

}
