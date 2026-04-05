package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.file.FileChannelService;
import com.sprint.mission.discodeit.service.file.FileMessageService;
import com.sprint.mission.discodeit.service.file.FileUserService;
import com.sprint.mission.discodeit.service.jcf.JCFChannelService;
import com.sprint.mission.discodeit.service.jcf.JCFMessageService;
import com.sprint.mission.discodeit.service.jcf.JCFUserService;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JavaApplication {
    public static void main(String[] args) {

//        Map<UUID, User> userMap = new HashMap<>();
//        Map<UUID, Channel> channelMap = new HashMap<>();
//        Map<UUID, Message> messageMap = new HashMap<>();
//
//        JCFUserService userService = new JCFUserService(userMap);
//        JCFChannelService channelService = new JCFChannelService(channelMap);
//        JCFMessageService messageService = new JCFMessageService(messageMap, userService, channelService);

        //기존 JCF 대신 FileService 이용
        UserService userService = new FileUserService();
        ChannelService channelService = new FileChannelService();
        MessageService messageService = new FileMessageService(userService, channelService);

        System.out.println("===== 테스트 시작 =====");

        //등록(생성)
        User user = new User("test1", "test1@email.com");
        userService.create(user);
        Channel channel = new Channel("ch1", "Hello1");
        channelService.create(channel);
        Message message = new Message("How are you1", user.getId(), channel.getId());
        messageService.create(message);
        Message message2 = new Message("How are you2", user.getId(), channel.getId());
        messageService.create(message2);

//        User user3 = new User("test3", "test3@email.com");
//        userService.create(user3);
//        Channel channel3 = new Channel("ch3", "Hello3");
//        channelService.create(channel3);
//        Message message3 = new Message("How are you3", user3.getId(), channel3.getId());
//        messageService.create(message3);
//        Message message4 = new Message("How are you4", user3.getId(), channel3.getId());
//        messageService.create(message4);
//        Message message5 = new Message("How are you5", user3.getId(), channel3.getId());
//        messageService.create(message5);

        System.out.println("등록 완료");

        //조회
        //조회 단건
        User foundUser = userService.find(user.getId());
        System.out.println("단건 조회 - 유저 : " + foundUser.getName());

        //조회 다건
        List<Message> allMessage = messageService.findAll();
        System.out.println("다건 조회 - 메세지 개수 : " + allMessage.size());

        for (Message msg : allMessage) {
            System.out.println("ID : " + msg.getId() + ", " + msg.getContent());
        }


        System.out.println("===== 데이터 수정 =====");

        //수정
        Message updateInfo = new Message("How are you111", user.getId(), channel.getId());
        messageService.update(message.getId(), updateInfo);
        System.out.println("내용이 수정되었습니다.");

        //수정된 데이터 조회
        Message updateMsg = messageService.find(message.getId());
        System.out.println("수정 - 변경된 내용 : " + updateMsg.getContent());
        System.out.println("수정 - 변경된 시각 : " + updateMsg.getUpdatedAt());


        System.out.println("===== 데이터 삭제 =====");

        //삭제
        UUID delId = message.getId();
        messageService.delete(delId);
        System.out.println("내용을 삭제하였습니다.");

        //조회를 통해 삭제되었는지 확인
        Message delCheck = messageService.find(delId);
        if(delCheck == null) {
            System.out.println("해당 내용이 삭제되었습니다.");
        } else {
            System.out.println("해당 내용이 아직 존재합니다.");
        }

        System.out.println("===== 테스트 종료 =====");

    }

}
