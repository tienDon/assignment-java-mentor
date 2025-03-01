/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import constance.PaymentType;

/**
 *
 * @author ASUS
 */
public abstract class PaymentMethod {

    protected String id;
    protected User user;
    protected double balance;
    protected PaymentType type;

    public PaymentMethod(String id, User user, double balance, PaymentType type) {
        this.id = id;
        this.user = user;
        this.balance = balance;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    // Abstract method for payment (lớp con phải triển khai)
    public abstract boolean pay(double amount);

    // Nạp tiền vào phương thức thanh toán
    public void addFunds(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }
}
