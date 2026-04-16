package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.dto.ChannelRequest;
import com.sprint.mission.discodeit.dto.ChannelResponse;
import com.sprint.mission.discodeit.dto.UserCreateRequest;
import com.sprint.mission.discodeit.dto.UserResponse;
import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static com.sprint.mission.discodeit.JavaApplication.*;

@SpringBootApplication
public class DiscodeitApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DiscodeitApplication.class, args);

		UserService userService = context.getBean(UserService.class);
		ChannelService channelService = context.getBean(ChannelService.class);
		MessageService messageService = context.getBean(MessageService.class);

		UserResponse user = setupUser(userService);
		ChannelResponse channel = setupChannel(channelService);

		messageCreateTest(messageService, channel, user);
	}

	private static UserResponse setupUser(UserService userService) {
		//DTO
		UserCreateRequest request = new UserCreateRequest(
				"woody", "woody@codeit.com", "woody1234", null
		);


		return userService.create(request);
	}

	public static ChannelResponse setupChannel(ChannelService channelService) {
		ChannelRequest request = new ChannelRequest("공지", "공지 채널입니다.");
		ChannelResponse channelResponse = channelService.create(request);

		return channelResponse;
	}

	public static void messageCreateTest(MessageService messageService, ChannelResponse channel, UserResponse author) {
		Message message = messageService.create("안녕하세요.", channel.id(), author.id());
		System.out.println("메시지 생성: " + message.getId());
	}

}
