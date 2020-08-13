package com.diamond;

import com.diamond.dao.DocDAO;
import com.diamond.entity.Doc;
import com.diamond.entity.Team;
import com.diamond.entity.User;
import com.diamond.entity.UserTeam;
import com.diamond.service.DocService;
import com.diamond.service.EmailService;
import com.diamond.service.UserTeamService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private EmailService emailService;
    @Autowired
    private UserTeamService userTeamService;
    @Autowired
    private DocService docService;
    @Autowired
    private DocDAO docDAO;
    @Test
    public void contextLoads() {
        System.out.println( docService.delete(1,2));


    }


}
