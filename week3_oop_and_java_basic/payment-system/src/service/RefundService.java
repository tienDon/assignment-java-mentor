/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.PaymentMethod;
import model.Transaction;

/**
 *
 * @author ASUS
 */
public interface RefundService {
    public boolean processRefund(Transaction transaction, PaymentMethod paymentMethod);
}
