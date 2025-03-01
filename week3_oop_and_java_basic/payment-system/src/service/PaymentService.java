/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.PaymentMethod;
import model.User;

/**
 *
 * @author ASUS
 */
public interface PaymentService {
    public boolean payment(User sender, User receiver, double amount, PaymentMethod paymentMethod) ;
}
