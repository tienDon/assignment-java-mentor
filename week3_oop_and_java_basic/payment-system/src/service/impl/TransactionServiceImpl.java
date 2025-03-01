/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.ArrayList;
import model.Transaction;
import service.TransactionService;

/**
 *
 * @author ASUS
 */
public class TransactionServiceImpl extends ArrayList<Transaction> implements TransactionService {

    @Override
    public void recordTransaction(Transaction tra) {
        this.add(tra);
    }
    
}
