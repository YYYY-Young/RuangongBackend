package com.diamond.dao;

import com.diamond.entity.AdminMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Classname AdminMenuDAO
 * @Description TODO
 * @Date 2020/8/10 20:35
 * @Created by lrf
 */
public interface AdminMenuDAO extends JpaRepository<AdminMenu, Integer> {
    AdminMenu findById(int id);
    List<AdminMenu> findAllByParentId(int parentId);
}
