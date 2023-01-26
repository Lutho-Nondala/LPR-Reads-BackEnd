package com.lpr.afsol.LPR.Reads.Controller;

import com.lpr.afsol.LPR.Reads.Entity.User;
import com.lpr.afsol.LPR.Reads.Service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/lprreads/user")
public class UserController {
    @Autowired
    private UserService SERVICE;

    @PostConstruct
    public void initRolesAndUser(){
        SERVICE.initRolesAndUser();
    }

    @PostMapping({"/registerNewUser"})
    @PreAuthorize("hasRole('Admin')")
    public User registerNewUser(@RequestBody User user){
        return this.SERVICE.registerNewUser(user);
    }

    @GetMapping({"/forAdmins"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This url is for admins.";
    }

    @GetMapping({"/forUsers"})
    @PreAuthorize("hasRole('User')")
    public String forUsers(){
        return "This url is for users.";
    }

    @PutMapping({"/update"})
    @PreAuthorize("hasRole('Admin')")
    public User update(@RequestBody User user){
        return this.SERVICE.update(user);
    }

    @GetMapping({"/getById/{username}"})
    @PreAuthorize("hasRole('Admin')")
    public User getById(@PathVariable String username){
        return this.SERVICE.getById(username);
    }

    @DeleteMapping({"/delete/{username}"})
    @PreAuthorize("hasRole('Admin')")
    public void delete(@PathVariable String username){
        this.SERVICE.deleteById(username);
    }

    @GetMapping({"/findAll"})
    @PreAuthorize("hasRole('Admin')")
    public List<User> findAll(){
        return this.SERVICE.findAll();
    }
}
