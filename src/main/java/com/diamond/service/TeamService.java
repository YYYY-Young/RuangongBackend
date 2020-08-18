package com.diamond.service;

import com.diamond.dao.TeamDAO;
import com.diamond.dao.UserTeamDAO;
import com.diamond.entity.Team;
import com.diamond.entity.UserTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname TeamService
 * @Description TODO
 * @Date 2020/8/11 14:08
 * @Created by lrf
 */
@Service
public class TeamService {
    @Autowired
    TeamDAO teamDAO;
    @Autowired
    UserTeamDAO userTeamDAO;

    @Transactional
    public void editTeam(Team team) {
        java.sql.Timestamp ctime = new java.sql.Timestamp(new java.util.Date().getTime());
        team.setTime(ctime);
        teamDAO.save(team);

    }

    public void initTeam(Team team) {
        editTeam(team);
        UserTeam userTeam = new UserTeam();
        userTeam.setUid(team.getLeaderid());
        userTeam.setTid(team.getId());
        userTeam.setIssys(true);
        java.sql.Timestamp ctime = new java.sql.Timestamp(new java.util.Date().getTime());
        userTeam.setTime(ctime);
        userTeamDAO.save(userTeam);
    }

    public int deleteTeam(int uid, int tid) {
        Team team = teamDAO.findById(tid);
        if (uid != team.getLeaderid()) {
            return 0;
        }
        List<UserTeam> alluserTeams = userTeamDAO.findAll();
        for (UserTeam userTeam : alluserTeams) {
            if (userTeam.getTid() == tid && !userTeam.isIsthrown() && userTeam.isIsaccept()) {
                userTeam.setIsthrown(true);
                userTeam.setTime(new java.sql.Timestamp(new java.util.Date().getTime()));
                userTeamDAO.save(userTeam);
            }
        }
        teamDAO.deleteById(tid);
        return 1;
    }
}


