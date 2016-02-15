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
        users.add(new UserModel(100002,"Audio album","Love song","Sony Music","Khali Fong",""));
        users.add(new UserModel(100003,"Audio album","Hurt","Sony Music","Johny Cash","Johny Cash"));
        users.add(new UserModel(100004,"Audio album","When the man comes around","Sony Music","Johny Cash","Johny Cash"));
        users.add(new UserModel(100001,"Audio album","A love supreme","Sony Music","John Coltrane",""));
        users.add(new UserModel(100005,"Audio album","I hung my head","Sony Music","Johny Cash","Johny Cash"));
    }


    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}
