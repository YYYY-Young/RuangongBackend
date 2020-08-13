package com.diamond.dao;

import com.diamond.entity.AdminRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Classname AdminRoleMenuDAO
 * @Description TODO
 * @Date 2020/8/10 20:37
 * @Created by lrf
 */
public interface AdminRoleMenuDAO extends JpaRepository<AdminRoleMenu,Integer> {
    List<AdminRoleMenu> findAllByRid(int rid);
    List<AdminRoleMenu> findAllByRid(List<Integer> rids);
    void deleteAllByRid(int rid);
}
