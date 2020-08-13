package com.diamond.service;

import com.diamond.dao.AdminUserRoleDAO;
import com.diamond.entity.AdminRole;
import com.diamond.entity.AdminUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname AdminUserRoleService
 * @Description TODO
 * @Date 2020/8/10 20:53
 * @Created by lrf
 */
@Service
public class AdminUserRoleService {
    @Autowired
    AdminUserRoleDAO adminUserRoleDAO;

    public List<AdminUserRole> listAllByUid(int uid) {
        return adminUserRoleDAO.findAllByUid(uid);
    }

    //    @Modifying
    @Transactional
    public void saveRoleChanges(int uid, List<AdminRole> roles) {
        adminUserRoleDAO.deleteAllByUid(uid);
        List<AdminUserRole> urs = new ArrayList<>();
        roles.forEach(r -> {
            AdminUserRole ur = new AdminUserRole();
            ur.setUid(uid);
            ur.setRid(r.getId());
            urs.add(ur);
        });
        adminUserRoleDAO.saveAll(urs);
    }
}
