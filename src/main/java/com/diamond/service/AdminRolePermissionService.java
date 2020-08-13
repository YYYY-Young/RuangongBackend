package com.diamond.service;

import com.diamond.dao.AdminRolePermissionDAO;
import com.diamond.entity.AdminPermission;
import com.diamond.entity.AdminRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname AdminRolePermissionService
 * @Description TODO
 * @Date 2020/8/10 20:52
 * @Created by lrf
 */
@Service
public class AdminRolePermissionService {
    @Autowired
    AdminRolePermissionDAO adminRolePermissionDAO;

    List<AdminRolePermission> findAllByRid(int rid) {
        return adminRolePermissionDAO.findAllByRid(rid);
    }

    //    @Modifying
    @Transactional
    public void savePermChanges(int rid, List<AdminPermission> perms) {
        adminRolePermissionDAO.deleteAllByRid(rid);
        List<AdminRolePermission> rps = new ArrayList<>();
        perms.forEach(p -> {
            AdminRolePermission rp = new AdminRolePermission();
            rp.setRid(rid);
            rp.setPid(p.getId());
            rps.add(rp);
        });
        adminRolePermissionDAO.saveAll(rps);
    }
}
