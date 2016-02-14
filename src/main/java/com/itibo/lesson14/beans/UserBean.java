package com.itibo.lesson14.beans;


import com.itibo.lesson14.models.UserModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.LinkedList;
import java.util.List;


@ViewScoped
@ManagedBean(name="users")
public class UserBean {

    private List<UserModel> users;

    @PostConstruct
    public void init(){

        users = new LinkedList<UserModel>();
        users.add(new UserModel(10001,"rock","rock","rock","rock","rock"));
        users.add(new UserModel(10002,"rock","rock","rock","rock","rock"));
        users.add(new UserModel(10003,"rock","rock","rock","rock","rock"));
    }


    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
