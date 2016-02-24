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
@ManagedBean
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


        users.add(new UserModel("100004", "Audio album", "Solitary man", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel("100001", "Audio album", "I hung my head", "Sony Music", "Sting", ""));
        users.add(new UserModel("100005", "Audio album", "I've been everywhere", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel("100002", "Audio album", "Love song", "Sony Music", "Khali Fong", ""));
        users.add(new UserModel("100003", "Audio album", "Black", "Sony Music", "Johny Cash", "Johny Cash"));

        users.add(new UserModel("100003", "Audio album", "House of the rising sun", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel("100004", "Audio album", "One", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel("100001", "Audio album", "Stolen car", "Sony Music", "Sting", ""));
        users.add(new UserModel("100002", "Audio album", "I hung my head", "Sony Music", "Sting", ""));
        users.add(new UserModel("100005", "Audio album", "Personal jesus", "Sony Music", "Johny Cash", "Johny Cash"));
        users.add(new UserModel("100010", "Audio album", "Big river", "Sony Music", "Johny Cash", "Johny Cash"));

    }

    public List<UserModel> getSublist() {

        int startPosition = currentPage * pageItems;
        int endPosition = startPosition + pageItems;

        List<UserModel> filteredLists = applyFilter();

        if (endPosition > filteredLists.size()) {
            endPosition = filteredLists.size();
        }
        return filteredLists.subList(startPosition, endPosition);
    }

    public List<UserModel> applyFilter() {

        List<UserModel> filteredList = new LinkedList<UserModel>();

        if (searchModel.getSku().isEmpty() && searchModel.getArtist().isEmpty() && searchModel.getAuthor().isEmpty()
                && searchModel.getPublisher().isEmpty() && searchModel.getTitle().isEmpty() && searchModel.getType().isEmpty()) {

            return users;
        }

        for (UserModel user : this.users) {


            if (user.getSku().contains(searchModel.getSku()) && !searchModel.getSku().isEmpty()) {
                filteredList.add(user);
                continue;
            }
            if (user.getArtist().contains(searchModel.getArtist().toLowerCase()) && !searchModel.getArtist().isEmpty()) {
                filteredList.add(user);
                continue;
            }
            if (user.getTitle().contains(searchModel.getTitle().toLowerCase()) && !searchModel.getTitle().isEmpty()) {
                filteredList.add(user);
                continue;
            }
            if (user.getAuthor().contains(searchModel.getAuthor().toLowerCase()) && !searchModel.getAuthor().isEmpty()) {
                filteredList.add(user);
                continue;
            }
            if (user.getPublisher().contains(searchModel.getPublisher().toLowerCase()) && !searchModel.getPublisher().isEmpty()) {
                filteredList.add(user);
            }
        }
        return filteredList;
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
