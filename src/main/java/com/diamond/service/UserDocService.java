package com.diamond.service;

import com.diamond.dao.DocDAO;
import com.diamond.dao.UserDocDAO;
import com.diamond.entity.Doc;
import com.diamond.entity.UserDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname UserDocService
 * @Description TODO
 * @Date 2020/8/12 11:27
 * @Created by lrf
 */
@Service
public class UserDocService {
    @Autowired
    UserDocDAO userDocDAO;
    @Autowired
    DocDAO docDAO;
    public void AddRecord(UserDoc userDoc) {
        userDocDAO.save(userDoc);
    }
    public List<UserDoc> userDocs(int uid){
       return userDocDAO.findAllByUid(uid);
    }
}
