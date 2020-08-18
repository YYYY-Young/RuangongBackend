package com.diamond.dao;

import com.diamond.entity.Team;
import com.diamond.entity.User;
import com.diamond.entity.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Classname UserTeamDAO
 * @Description TODO
 * @Date 2020/8/11 13:56
 * @Created by lrf
 */
public interface UserTeamDAO extends JpaRepository<UserTeam,Integer> {
    List<UserTeam> findAllByUid(int uid);
    List<UserTeam> findAllByTid(int tid);
    UserTeam findById(int  id);
    @Query(value = "select *from user_team where uid=?1 and isaccept=1",nativeQuery = true)
    List<UserTeam> findacceptedteams(int uid);
    @Query(value = "select *from user_team where uid=?1 and isaccept=0",nativeQuery = true)
    List<UserTeam> findnotacceptedteams(int uid);
    @Query(value = "select *from user_team where tid=?1 and isaccept=1",nativeQuery = true)
    List<UserTeam> findacceptedusers(int tid);
    @Query(value = "select *from user_team where tid=?1 and isaccept=0",nativeQuery = true)
    List<UserTeam> findnotacceptedusers(int tid);

    @Transactional
    @Modifying
    void deleteByUidAndTid(int uid,int tid);
    @Transactional
    @Modifying
    void deleteAllByTid(int tid);
    UserTeam findByUidAndTid(int uid,int tid);
    @Transactional
    @Modifying
    void deleteById(int id);

}
