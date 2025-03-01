/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import service.FraudDetectionService;

/**
 *
 * @author ASUS
 */
public class FraudDetectionServiceImpl implements FraudDetectionService{
    private final int hour = 1;
    @Override
    public boolean isFraudDetectionService(String userId, double amount) {
        if(amount>=5000){
            return true;
        }
        return false;
    }
    
}
