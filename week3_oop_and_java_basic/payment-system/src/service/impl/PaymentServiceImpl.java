/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import constance.TransactionStatus;
import constance.TransactionType;
import java.time.LocalDateTime;
import model.PaymentMethod;
import model.Transaction;
import model.User;
import service.PaymentService;

/**
 *
 * @author ASUS
 */
public class PaymentServiceImpl implements PaymentService {

    private OTPServiceImpl otpService;
    private TransactionServiceImpl transactionService;
    private FraudDetectionServiceImpl fraudDetectionService;

    @Override
    public boolean payment(User sender, User receiver, double amount, PaymentMethod paymentMethod) {
        if (amount > 5000) {
            String otp = otpService.generateOTP(sender.getId());
            System.out.println(otp);
            int attempts = 0;
            while (attempts < 3) {
                System.out.print("Nhập OTP: ");
                String userOtp = new java.util.Scanner(System.in).nextLine();
                if (otpService.validateOTP(sender.getId(), userOtp)) {
                    System.out.println("OTP hợp lệ, tiếp tục thanh toán.");
                    break;
                } else {
                    attempts++;
                    System.out.println("OTP không chính xác. Thử lại!");
                    if (attempts == 3) {
                        System.out.println("Quá số lần nhập sai OTP. Giao dịch bị hủy.");
                        return false;
                    }
                }
            }
        }

        // Kiểm tra dấu hiệu gian lận
        if (fraudDetectionService.isFraudDetectionService(sender.getId(), amount)) {
            System.out.println("Giao dịch bị chặn do phát hiện dấu hiệu gian lận.");
            return false;
        }

        // Kiểm tra số dư của phương thức thanh toán 
        if(paymentMethod.getBalance() >= amount){
            return true;
        }
        

        // Xử lý thanh toán
        System.out.println("Thanh toán thành công qua " + paymentMethod.getType());
        transactionService.recordTransaction(new Transaction(sender.getId(), receiver.getId(), amount, paymentMethod, TransactionType.TOP_UP, TransactionStatus.SUCCESS, LocalDateTime.now()));
        return true;

    }

}
