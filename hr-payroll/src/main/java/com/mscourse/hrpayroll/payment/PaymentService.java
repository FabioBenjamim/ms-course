package com.mscourse.hrpayroll.payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, Integer days) {
		return new Payment("Fabio", 100.0, days);
	}
}
