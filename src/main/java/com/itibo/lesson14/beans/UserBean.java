package com.itibo.lesson14.beans;


import com.itibo.lesson14.models.UserModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@ViewScoped
@ManagedBean(name = "users")
public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<UserModel> users;
    private UserModel searchModel;
    private int currentPage;
    private int pageItems;


    @PostConstruct
    public void init() {


        currentPage = 0;
        pageItems = 3;

        searchModel = new UserModel();

        users = new LinkedList<UserModel>();
        users.add(new UserModel("100002", "Audio album", "Love song", "Sony Music", "Khali Fong", ""));
        users.add(new UserModel("100003", "Audio album", "Hurt", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel("100004", "Audio album", "When the man comes around", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel("100001", "Audio album", "A love supreme", "Sony Music", "John Coltrane", ""));
        users.add(new UserModel("100005", "Audio album", "I hung my head", "Sony Music", "Johny Cash", "Johny Cash"));


        users.add(new UserModel("100004", "Audio album", "When the man comes around", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel("100001", "Audio album", "A love supreme", "Sony Music", "John Coltrane", ""));
        users.add(new UserModel("100005", "Audio album", "I hung my head", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel("100002", "Audio album", "Love song", "Sony Music", "Khali Fong", ""));
        users.add(new UserModel("100003", "Audio album", "Hurt", "Sony Music", "Johny Cash", "Johny Cash"));

        users.add(new UserModel("100003", "Audio album", "Hurt", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel("100004", "Audio album", "When the man comes around", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel("100001", "Audio album", "A love supreme", "Sony Music", "John Coltrane", ""));
        users.add(new UserModel("100002", "Audio album", "Love song", "Sony Music", "Khali Fong", ""));
        users.add(new UserModel("100005", "Audio album", "I hung my head", "Sony Music", "Johny Cash", "Johny Cash"));
    }

    public List<UserModel> getSublist() {

        int startPosition = currentPage * pageItems;
        int endPosition = startPosition + pageItems;

        if (endPosition > applyFilter().size()) {
            endPosition = applyFilter().size();
        }
        return this.applyFilter().subList(startPosition, endPosition);
    }

    public List<UserModel> applyFilter() {

        List<UserModel> filteredList = new ArrayList<UserModel>();

        if (!searchModel.getArtist().isEmpty() || !searchModel.getAuthor().isEmpty() || !searchModel.getPublisher().isEmpty()
                || !searchModel.getTitle().isEmpty() || !searchModel.getSku().isEmpty()) {

            for (UserModel user : this.users) {
                if (user.getSku().contains(searchModel.getSku()) || user.getTitle().contains(searchModel.getTitle()) ||
                        user.getPublisher().contains(searchModel.getPublisher()) || user.getAuthor().contains(searchModel.getAuthor())
                        || user.getArtist().contains(searchModel.getArtist())) {

                    filteredList.add(user);
                }
            }
        }

        return users;
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

    public UserModel getSearchModel() {
        return searchModel;
    }

    public void setSearchModel(UserModel searchModel) {
        this.searchModel = searchModel;
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
