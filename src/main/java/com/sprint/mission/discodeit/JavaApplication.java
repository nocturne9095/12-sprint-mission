package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.Service;
import com.sprint.mission.discodeit.service.jcf.JCFService;

public class JavaApplication {
    public static void main(String[] args) {
        //사용자 테스트 시작
        System.out.println("----------사용자 테스트 시작----------");
        Service service = new JCFService();


        User user = new User("test1", "test@email.com", "1234", "test1");
        service.save(user);
        System.out.println(service.findAll());


        System.out.println("----------사용자 테스트 끝----------");
    }
}
