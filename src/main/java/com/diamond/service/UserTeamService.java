package com.diamond.service;

import com.diamond.dao.TeamDAO;
import com.diamond.dao.UserDAO;
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
    @Autowired
    TeamDAO teamDAO;
    @Autowired
    UserDAO userDAO;
    public List<UserTeam> listAllByTid(int tid){
        List<UserTeam> userTeamList= userTeamDAO.findacceptedusers(tid);
        for(UserTeam userTeam:userTeamList){
            userTeam.setTeam(teamDAO.findById(userTeam.getTid()));
            userTeam.setUser(userDAO.findById(userTeam.getUid()));
        }
        return userTeamList;
    }
    public List<UserTeam> listAllByUid(int uid){

        List<UserTeam> userTeamList= userTeamDAO.findacceptedteams(uid);
        for(UserTeam userTeam:userTeamList){
            userTeam.setTeam(teamDAO.findById(userTeam.getTid()));
            userTeam.setUser(userDAO.findById(userTeam.getUid()));
        }
        return userTeamList;
    }
    public List<UserTeam>listAllnotacceptedByTid(int tid){
        List<UserTeam> userTeamList=userTeamDAO.findnotacceptedusers(tid);
        for(UserTeam userTeam:userTeamList){
            userTeam.setTeam(teamDAO.findById(userTeam.getTid()));
            userTeam.setUser(userDAO.findById(userTeam.getUid()));
        }
        return userTeamList;
    }
    public List<UserTeam>listAllnotacceptedByUid(int uid){
        List<UserTeam> userTeamList=userTeamDAO.findnotacceptedteams(uid);
        for(UserTeam userTeam:userTeamList){
            userTeam.setTeam(teamDAO.findById(userTeam.getTid()));
            userTeam.setUser(userDAO.findById(userTeam.getUid()));
        }
        return userTeamList;
    }
    public List<UserTeam>listAllthrownByUid(int uid){
        List<UserTeam> userTeamList=userTeamDAO.findthrownrecords(uid);
        for(UserTeam userTeam:userTeamList){
            userTeam.setTeam(teamDAO.findById(userTeam.getTid()));
            userTeam.setUser(userDAO.findById(userTeam.getUid()));
        }
        return userTeamList;
    }

    public int acceptinvatation(int id){
        UserTeam userTeam=userTeamDAO.findById(id);
        if(userTeam==null){
            return 0;
        }
        userTeam.setIsaccept(true);
        java.sql.Timestamp ctime = new java.sql.Timestamp(new java.util.Date().getTime());
        userTeam.setTime(ctime);
        userTeamDAO.save(userTeam);
        return 1;
    }

    @Transactional
    public void initmembers(int tid,List<UserTeam> users){
        userTeamDAO.deleteAllByTid(tid);
        List<UserTeam> userTeamList =new ArrayList<>();
        users.forEach(r->{
            UserTeam ut=new UserTeam();
            ut.setTid(tid);
            ut.setUid(r.getUid());
            userTeamList.add(ut);
        });
        userTeamDAO.saveAll(userTeamList);
    }
    @Transactional
    public void addOrUpdate(UserTeam userTeam){
        java.sql.Timestamp ctime = new java.sql.Timestamp(new java.util.Date().getTime());
        userTeam.setTime(ctime);
        userTeamDAO.save(userTeam);
    }
    public UserTeam  findByUidAndTid(int uid,int tid){
        UserTeam userTeam=userTeamDAO.findByUidAndTid(uid,tid);
        if(userTeam!=null){
            userTeam.setTeam(teamDAO.findById(userTeam.getTid()));
        }
        return userTeam;
    }
    @Transactional
    public int deleteUserTeam(int uid,int id){
        UserTeam userTeam=userTeamDAO.findById(id);
        int deleteduid=userTeam.getUid();
        int tid=userTeam.getTid();
        Team team=teamDAO.findById(tid);
        int founder=team.getLeaderid();
        if((!isTeamsys(uid,tid)&&deleteduid!=uid)||(deleteduid==founder&&uid!=founder)){
            return 0;
        }
        userTeamDAO.deleteById(id);
        UserTeam deleterecord=new UserTeam();
        deleterecord.setUid(deleteduid);
        deleterecord.setTid(tid);
        deleterecord.setIsthrown(true);
        java.sql.Timestamp ctime = new java.sql.Timestamp(new java.util.Date().getTime());
        deleterecord.setTime(ctime);
        userTeamDAO.save(deleterecord);
        return 1;
    }
    public boolean isTeammember(int uid,int tid){
        return userTeamDAO.checkifismember(uid, tid) != null;
    }
    public boolean isTeamsys(int uid,int tid){
        UserTeam userTeam=userTeamDAO.checkifismember(uid,tid);
        return userTeam != null && userTeam.isIssys();
    }
    @Transactional
    public void deletebyidfast(int id){
        userTeamDAO.deleteById(id);
    }

}
