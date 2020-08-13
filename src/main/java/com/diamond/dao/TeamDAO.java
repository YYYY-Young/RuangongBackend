package com.diamond.dao;

import com.diamond.entity.Team;
import com.diamond.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Classname TeamDao
 * @Description TODO
 * @Date 2020/8/11 13:54
 * @Created by lrf
 */
public interface TeamDAO extends JpaRepository<Team,Integer> {

}
