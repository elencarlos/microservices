package com.ms.payroll.services;

import com.ms.payroll.entities.Payment;
import com.ms.payroll.entities.Worker;
import com.ms.payroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long id, int days) {
        Worker worker = workerFeignClient.findById(id).getBody();
        return new Payment(Objects.requireNonNull(worker).getName(), worker.getDailyIncome(), days);
    }

}
