package com.diamond.service;

import com.diamond.dao.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
