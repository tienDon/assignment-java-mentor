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
public class CreditCard extends PaymentMethod{

    private double creditLimit; // Hạn mức tín dụng

    public CreditCard(String id, User user, double balance, PaymentType type) {
        super(id, user, balance, type);
    }



    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }


    @Override
    public boolean pay(double amount) {
        if (amount <= balance + creditLimit) {
            if(type==PaymentType.INTERNATIONAL){
                balance = balance-amount*0.02;
            }else{
                balance -= amount;
            }
            
            return true;
        }
        return false;
    }
    
}
