package com.diamond.dao;

import com.diamond.entity.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname AdminRoleDAO
 * @Description TODO
 * @Date 2020/8/10 20:36
 * @Created by lrf
 */
public interface AdminRoleDAO extends JpaRepository<AdminRole, Integer> {
    AdminRole findById(int id);
}