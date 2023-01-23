package com.lpr.afsol.LPR.Reads.Factory;

import com.lpr.afsol.LPR.Reads.Entity.Role;
import com.lpr.afsol.LPR.Reads.Entity.User;

import java.util.Set;

public class UserFactory {
    public static User buildUser(String userName, String userFirstName, String userLastName, String password, Set<Role> role){
        if (userName.isEmpty() || userName == null){
            throw new IllegalArgumentException("Username is required!");
        }
        if (userFirstName.isEmpty() || userFirstName == null){
            throw new IllegalArgumentException("The user's first name is required!");
        }
        if (userLastName.isEmpty() || userLastName == null){
            throw new IllegalArgumentException("The user's last name is required!");
        }
        if (password.isEmpty() || password == null){
            throw new IllegalArgumentException("Password is required!");
        }
        if (role.isEmpty() || role == null){
            throw new IllegalArgumentException("Role of the user is required is required!");
        }

        return new User.Builder().userName(userName).userFirstName(userFirstName).userLastName(userLastName).password(password).role(role).build();
    }
}
