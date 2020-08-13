package com.diamond.dao;

import com.diamond.entity.AdminUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Classname AdminUserRoleDAO
 * @Description TODO
 * @Date 2020/8/10 20:38
 * @Created by lrf
 */

public interface AdminUserRoleDAO extends JpaRepository<AdminUserRole, Integer> {
    List<AdminUserRole> findAllByUid(int uid);
    void deleteAllByUid(int uid);
}

