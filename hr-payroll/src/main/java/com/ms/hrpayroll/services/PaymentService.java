package com.ms.hrpayroll.services;

import com.ms.hrpayroll.entities.Payment;
import com.ms.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long id, int days) {
        Map<String, String> uriParameters = new HashMap<>();
        uriParameters.put("id", String.valueOf(id));
        Worker worker = restTemplate.getForObject(workerHost.concat("/workers/{id}"), Worker.class, uriParameters);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
