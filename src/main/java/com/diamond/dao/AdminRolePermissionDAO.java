package com.diamond.dao;

import com.diamond.entity.AdminRolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Classname AdminRolePermissionDAO
 * @Description TODO
 * @Date 2020/8/10 20:38
 * @Created by lrf
 */
public interface AdminRolePermissionDAO extends JpaRepository<AdminRolePermission, Integer> {
    List<AdminRolePermission> findAllByRid(int rid);
    List<AdminRolePermission> findAllByRid(List<Integer> rids);
    void deleteAllByRid(int rid);
}
