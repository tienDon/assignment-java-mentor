/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import constance.TransactionStatus;
import constance.TransactionType;
import java.time.LocalDateTime;
import java.time.LocalTime;
import model.CreditCard;
import model.PaymentMethod;
import model.Transaction;
import service.RefundService;

/**
 *
 * @author ASUS
 */
public class RefundServiceImpl implements RefundService{
    TransactionServiceImpl d = new TransactionServiceImpl();
    @Override
    public boolean processRefund(Transaction transaction, PaymentMethod paymentMethod) {
        
        if(transaction.getTimestamp().isAfter(LocalDateTime.now().minusDays(7))){
            paymentMethod.setBalance(paymentMethod.getBalance()+ transaction.getAmount()) ;
            Transaction tmp = new Transaction(transaction.getSender(), 
                    transaction.getReceiver(), transaction.getAmount(), 
                    transaction.getMethod(), transaction.getType(), 
                    TransactionStatus.REFUNDED, LocalDateTime.now());
            d.recordTransaction(tmp);
            return true;
        }
        return false;
    }

   
}
