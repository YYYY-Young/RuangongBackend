package com.diamond;

import com.diamond.dao.CommentDAO;
import com.diamond.dao.DocDAO;
import com.diamond.dao.UserDocDAO;
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

import javax.sound.midi.Soundbank;
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
    @Autowired
    private UserDocDAO userDocDAO;
    @Autowired
    private CommentDAO commentDAO;
    @Test
    public void contextLoads() {
//        System.out.println(commentDAO.findAllByDocidOrderByTimeDesc(1));
        System.out.println(commentDAO.findAllByUidOrderByTimeDesc(1));


    }


}
