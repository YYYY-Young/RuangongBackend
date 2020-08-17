package com.diamond.service;

import com.diamond.dao.TeamDAO;
import com.diamond.dao.UserTeamDAO;
import com.diamond.entity.Team;
import com.diamond.entity.UserTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void  editTeam(Team team){
        java.sql.Timestamp ctime = new java.sql.Timestamp(new java.util.Date().getTime());
        team.setTime(ctime);
        teamDAO.save(team);

    }
    public void initTeam(Team team){
        editTeam(team);
        UserTeam userTeam=new UserTeam();
        userTeam.setUid(team.getLeaderid());
        userTeam.setTid(team.getId());
        userTeam.setIssys(true);
        userTeamDAO.save(userTeam);
    }
}
