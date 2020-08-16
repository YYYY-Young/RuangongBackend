package com.diamond.service;

import com.diamond.dao.TeamDAO;
import com.diamond.entity.Team;
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
    @Transactional
    public void  editTeam(Team team){
        teamDAO.save(team);

    }
}
