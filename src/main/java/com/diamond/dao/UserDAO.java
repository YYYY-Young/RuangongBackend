package com.diamond.dao;

import com.diamond.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname UserDAO
 * @Description TODO
 * @Date 2020/8/10 15:19
 * @Created by lrf
 */
public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User getByUsernameAndPassword(String username,String password);
}
