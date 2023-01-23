package com.lpr.afsol.LPR.Reads.Entity;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
@Entity
public class User {
    @NotNull
    @Id
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;

    public User(){

    }

    public User(Builder builder){
        this.userName = builder.userName;
        this.userFirstName = builder.userFirstName;
        this.userLastName = builder.userLastName;
        this.userPassword = builder.password;
        this.role = builder.role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public static class Builder{
        private String userName, userFirstName, userLastName, password;
        private Set<Role> role;

        public Builder userName(String userName){
            this.userName = userName;
            return this;
        }

        public Builder userFirstName(String userFirstName){
            this.userFirstName = userFirstName;
            return this;
        }

        public Builder userLastName(String userLastName){
            this.userLastName = userLastName;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder role(Set<Role> role){
            this.role = role;
            return this;
        }

        public Builder copy(User user){
            this.userName = user.userName;
            this.userFirstName = user.userFirstName;
            this.userLastName = user.userLastName;
            this.password = user.userPassword;
            this.role = user.role;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
