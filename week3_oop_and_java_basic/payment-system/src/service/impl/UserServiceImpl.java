/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.ArrayList;
import model.User;
import service.UserService;

/**
 *
 * @author ASUS
 */
public class UserServiceImpl implements UserService{
    ArrayList<User> listUser = new ArrayList<>();
    
    @Override
    public boolean login(String username, String password) {
        for (User user : listUser) {
            if(username.trim().equals(user.getName()) && password.equals(user.getPassword())){
                System.out.println("login success");
                return true;
            }
        }
        return false;
    }

    @Override
    public void logout() {
        System.out.println("logout");
    }
    
}
