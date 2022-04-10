package com.teachMeSkills.lesson27.twitterServlet.service;

import com.teachMeSkills.lesson27.twitterServlet.entity.User;
import com.teachMeSkills.lesson27.twitterServlet.storage.UserStorage;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static final UserStorage userStorage = new UserStorage();


    public boolean addUser(User user) {
        if (userStorage.isExistByLogin(user.getLogin())) {
            return false;
        }
        userStorage.save(user);
        return true;
    }

    public int getIdUser(){
        return userStorage.getIdUserStorage();
    }

    public User findByLogin(String login){
        return userStorage.findByLogin(login);
    }

    public boolean editRole(int userId){
        boolean isEdited = userStorage.editRoleById(userId);
        return  isEdited;
    }

    public boolean deleteUser(int userId){
        boolean isDeleted = userStorage.deleteUserByID(userId);
        return  isDeleted;
    }

    public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();
        userList = userStorage.getAllUsers();
        return userList;
    }

    public User getUserByID(int idUser){
        return userStorage.getUserById(idUser);
    }


}
