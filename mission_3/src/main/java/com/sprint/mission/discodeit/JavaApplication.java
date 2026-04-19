package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.dto.*;
import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.repository.*;
import com.sprint.mission.discodeit.repository.file.*;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.basic.BasicChannelService;
import com.sprint.mission.discodeit.service.basic.BasicMessageService;
import com.sprint.mission.discodeit.service.basic.BasicUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserService userService,
                                 ChannelService channelService,
                                 MessageService messageService,
                                 UserRepository userRepository) {
        return args -> {
            System.out.println("====================");
            System.out.println("활성화된 리포지토리 구현체 : " + userRepository.getClass().getSimpleName());
            System.out.println("====================");

            UserResponse user = setupUser(userService);
            ChannelResponse channel = setupChannel(channelService);
            messageCreateTest(messageService, channel, user);
            System.out.println("빈 주입을 통한 테스트 완료");
        };
    }

    static UserResponse setupUser(UserService userService) {
        //DTO
        UserCreateRequest request = new UserCreateRequest(
                "woody", "woody@codeit.com", "woody1234", null
        );

        UserResponse response = userService.create(request);
        return response;
    }

    static ChannelResponse setupChannel(ChannelService channelService) {
        ChannelRequest request = new ChannelRequest("공지", "공지 채널입니다.");
        ChannelResponse channel = channelService.create(request);

        return channel;
    }

    static void messageCreateTest(MessageService messageService, ChannelResponse channel, UserResponse author) {
        MessageRequest request = new MessageRequest("안녕하세요.", channel.id(), author.id(), null);
        MessageResponse response = messageService.create(request);
        System.out.println("메시지 생성: " + response.id());
    }

//
//    public static void main(String[] args) {
//        // 레포지토리 초기화
//        UserRepository userRepository = new FileUserRepository();
//        UserStatusRepository userStatusRepository = new FileUserStatusRepository();
//        BinaryContentRepository binaryContentRepository = new FileBinaryContentRepository();
//        ChannelRepository channelRepository = new FileChannelRepository();
//        MessageRepository messageRepository = new FileMessageRepository();
//        ReadStatusRepository readStatusRepository = new FileReadStatusRepository();
//
//        // 서비스 초기화
//        UserService userService = new BasicUserService(userRepository, userStatusRepository, binaryContentRepository);
//        ChannelService channelService = new BasicChannelService(channelRepository, readStatusRepository, messageRepository);
//        MessageService messageService = new BasicMessageService(messageRepository, channelRepository,
//                userRepository, binaryContentRepository);
//
//        // 셋업
//        UserResponse user = setupUser(userService);
//        ChannelResponse channel = setupChannel(channelService);
//        // 테스트
//        messageCreateTest(messageService, channel, user);
//    }

}
