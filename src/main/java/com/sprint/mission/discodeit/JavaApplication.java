package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.Service;
import com.sprint.mission.discodeit.service.jcf.JCFService;

public class JavaApplication {
    public static void main(String[] args) {
        //사용자 테스트 시작
        System.out.println("----------사용자 테스트 시작----------");
        Service service = new JCFService();


        User user1 = new User("test1", "test1@email.com", "12341", "test1");
        User user2 = new User("test2", "test2@email.com", "12342", "test2");

        service.save(user1);
        System.out.println(service.findAll());


        System.out.println("----------사용자 테스트 끝----------");
    }
}
