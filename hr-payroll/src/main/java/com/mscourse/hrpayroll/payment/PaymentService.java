package com.mscourse.hrpayroll.payment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mscourse.hrpayroll.feignclients.WorkerFeignClient;
import com.mscourse.hrpayroll.worker.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(Long workerId, Integer days) {
		Worker worker = workerFeignClient.findById(workerId).getBody().get();
			
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
