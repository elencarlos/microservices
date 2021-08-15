package com.ms.hrpayroll.services;

import com.ms.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public Payment getPayment(long id, int days) {
        return new Payment("Bob", 200.0, days);
    }

}
