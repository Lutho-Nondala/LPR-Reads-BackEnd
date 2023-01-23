package com.lpr.afsol.LPR.Reads.Service;

import com.lpr.afsol.LPR.Reads.Entity.Role;
import com.lpr.afsol.LPR.Reads.Entity.User;
import com.lpr.afsol.LPR.Reads.Factory.UserFactory;
import com.lpr.afsol.LPR.Reads.Repository.RoleDao;
import com.lpr.afsol.LPR.Reads.Repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    @Autowired
    private UserDao REPOSITORY;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user){
        Role role = roleDao.findById("User").get();

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);

        user.setUserPassword(encodePassword(user.getUserPassword()));
        return this.REPOSITORY.save(user);
    }

    public User update(User user){
        return this.REPOSITORY.save(user);
    }

    public User getById(String username){
        return this.REPOSITORY.findById(username).get();
    }

    public void deleteById(String username){
        this.REPOSITORY.deleteById(username);
    }

    public List<User> findAll(){
        return StreamSupport.stream(this.REPOSITORY.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public void initRolesAndUser(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for new users");
        roleDao.save(userRole);

        User adminUser = new User();
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser = UserFactory.buildUser("Sakazuki", "Akainu", "MagmaGoat", encodePassword("SpaceHolePuncher"), adminRoles);
        REPOSITORY.save(adminUser);

        User user = new User();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user = UserFactory.buildUser("AfroHaze", "Aokiji", "Kuzan", encodePassword("AtlanticCyclist"), userRoles);
        REPOSITORY.save(user);
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
