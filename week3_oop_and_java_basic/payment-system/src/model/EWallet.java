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
public class EWallet extends PaymentMethod{
    private final double limitedMoney =5000;

    public EWallet(String id, User user, double balance, PaymentType type) {
        super(id, user, balance, type);
    }

    

    @Override
    public boolean pay(double amount) {
        if (amount <= balance && amount<=limitedMoney) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
}
