/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import constance.UserStatus;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class User {
    private String id;
    private String name;
    private String password;
    private UserStatus status;
    private ArrayList<PaymentMethod> paymentMethods;

    public User() {
    }

    public User(String id, String name, String password, UserStatus status, ArrayList<PaymentMethod> paymentMethods) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.status = status;
        this.paymentMethods = paymentMethods;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public ArrayList<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public void setPaymentMethods(ArrayList<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    
    
    
    
}
