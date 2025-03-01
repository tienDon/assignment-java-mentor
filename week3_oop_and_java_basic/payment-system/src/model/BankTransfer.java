/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import constance.PaymentType;
import constance.TransactionType;

/**
 *
 * @author ASUS
 */
public class BankTransfer extends PaymentMethod {
    private int timePending;
    public BankTransfer(String id, User user, double balance, PaymentType type) {
        super(id, user, balance, type);
    }
    
    @Override
    public boolean pay(double amount) {
        if (amount <= balance) {
            timePending = (type == PaymentType.INTERNATIONAL) ? 3 : 0;
            if(amount>2000){
                balance = (balance - amount* 1.01);
            }else{
                balance -= amount;
            }
            
            return true;
        }
        return false;
    }
}
