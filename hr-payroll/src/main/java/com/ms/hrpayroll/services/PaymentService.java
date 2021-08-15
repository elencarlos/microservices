package com.ms.hrpayroll.services;

import com.ms.hrpayroll.entities.Payment;
import com.ms.hrpayroll.entities.Worker;
import com.ms.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long id, int days) {
        Worker worker = workerFeignClient.findById(id).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
