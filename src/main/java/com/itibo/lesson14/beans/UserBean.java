package com.itibo.lesson14.beans;


import com.itibo.lesson14.models.UserModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


@ViewScoped
@ManagedBean(name = "users")
public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<UserModel> users;
    private int currentPage;
    private int pageItems;


    @PostConstruct
    public void init() {

        currentPage = 0;
        pageItems = 3;

        users = new LinkedList<UserModel>();
        users.add(new UserModel(100002, "Audio album", "Love song", "Sony Music", "Khali Fong", ""));
        users.add(new UserModel(100003, "Audio album", "Hurt", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel(100004, "Audio album", "When the man comes around", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel(100001, "Audio album", "A love supreme", "Sony Music", "John Coltrane", ""));
        users.add(new UserModel(100005, "Audio album", "I hung my head", "Sony Music", "Johny Cash", "Johny Cash"));


        users.add(new UserModel(100004, "Audio album", "When the man comes around", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel(100001, "Audio album", "A love supreme", "Sony Music", "John Coltrane", ""));
        users.add(new UserModel(100005, "Audio album", "I hung my head", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel(100002, "Audio album", "Love song", "Sony Music", "Khali Fong", ""));
        users.add(new UserModel(100003, "Audio album", "Hurt", "Sony Music", "Johny Cash", "Johny Cash"));

        users.add(new UserModel(100003, "Audio album", "Hurt", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel(100004, "Audio album", "When the man comes around", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel(100001, "Audio album", "A love supreme", "Sony Music", "John Coltrane", ""));
        users.add(new UserModel(100002, "Audio album", "Love song", "Sony Music", "Khali Fong", ""));
        users.add(new UserModel(100005, "Audio album", "I hung my head", "Sony Music", "Johny Cash", "Johny Cash"));
    }

    public List<UserModel> getSublist(){

        int startPosition = currentPage*pageItems;
        int endPosition = startPosition+pageItems;

        if(endPosition>users.size()){
            endPosition = users.size();
        }
        return users.subList(startPosition,endPosition);
    }


    public void save() {
        for (UserModel user : users) {
            user.setEditable(false);
        }
    }

    public void edit(UserModel user) {
        user.setEditable(true);
    }

    public void action(AjaxBehaviorEvent event) throws javax.faces.event.AbortProcessingException {
        currentPage = (Integer) event.getComponent().getAttributes().get("index") - 1;
    }

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageItems() {
        return pageItems;
    }

    public void setPageItems(int pageItems) {
        this.pageItems = pageItems;
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "users=" + users +
                ", currentPage=" + currentPage +
                ", pageItems=" + pageItems +
                '}';
    }
}
