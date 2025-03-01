/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.util.Random;
import service.OTPService;

/**
 *
 * @author ASUS
 */
public class OTPServiceImpl implements OTPService{

    @Override
    public String generateOTP(String userId) {
        Random random = new Random();
        return String.valueOf(1000 + random.nextInt(9000));
    }
    
    public boolean validateOTP(String userId, String otp){
        return true;
    }
    
}
