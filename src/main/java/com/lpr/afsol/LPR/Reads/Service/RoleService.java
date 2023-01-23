package com.lpr.afsol.LPR.Reads.Service;

import com.lpr.afsol.LPR.Reads.Entity.Role;
import com.lpr.afsol.LPR.Reads.Repository.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role){
        return roleDao.save(role);
    }
}
