package com.diamond.dao;

import com.diamond.entity.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname AdminPermissionDAO
 * @Description TODO
 * @Date 2020/8/10 20:36
 * @Created by lrf
 */
public interface AdminPermissionDAO extends JpaRepository<AdminPermission, Integer> {
    AdminPermission findById(int id);
}
