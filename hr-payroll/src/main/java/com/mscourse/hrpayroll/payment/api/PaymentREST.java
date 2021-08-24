package com.mscourse.hrpayroll.payment.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscourse.hrpayroll.payment.Payment;
import com.mscourse.hrpayroll.payment.PaymentService;

@RestController
@RequestMapping(value = "/payment")
public class PaymentREST {

	@Autowired
	PaymentService service = new PaymentService();
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		return ResponseEntity.ok(service.getPayment(workerId, days));
	}
}
