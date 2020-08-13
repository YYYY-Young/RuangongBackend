package com.diamond.service;

import com.diamond.dao.UserTeamDAO;
import com.diamond.entity.Team;
import com.diamond.entity.User;
import com.diamond.entity.UserTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserTeamService
 * @Description TODO
 * @Date 2020/8/11 14:34
 * @Created by lrf
 */
@Service
public class UserTeamService {
    @Autowired
    UserTeamDAO userTeamDAO;
    public List<UserTeam> listAllByTid(int tid){
        return userTeamDAO.findAllByTid(tid);
    }
    public List<UserTeam> listAllByUid(int uid){
        return userTeamDAO.findAllByUid(uid);
    }
    @Transactional
    public void saveUserChanges(int tid,List<User> users){
        userTeamDAO.deleteAllByTid(tid);
        List<UserTeam> userTeamList =new ArrayList<>();
        users.forEach(r->{
            UserTeam ut=new UserTeam();
            ut.setTid(tid);
            ut.setUid(r.getId());
            userTeamList.add(ut);
        });
        userTeamDAO.saveAll(userTeamList);
    }
    public void addOrUpdate(UserTeam userTeam){
        userTeamDAO.save(userTeam);
    }
    public UserTeam  findByUidAndTid(int uid,int tid){
        UserTeam userTeam=userTeamDAO.findByUidAndTid(uid,tid);
        return userTeam;
    }
    public void deleteUserTeam(UserTeam userTeam){
        userTeamDAO.delete(userTeam);
    }
    public boolean isTeammember(int uid,int tid){
        return userTeamDAO.findByUidAndTid(uid, tid) != null;
    }

}
