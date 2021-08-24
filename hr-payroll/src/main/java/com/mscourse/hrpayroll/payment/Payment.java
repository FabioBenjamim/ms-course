package com.mscourse.hrpayroll.payment;

import java.io.Serializable;

public class Payment implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
	public Payment(String name, Double dailyIncome, Integer days) {
		super();
		this.name = name;
		this.dailyIncome = dailyIncome;
		this.days = days;
	}

	private String name;
	private Double dailyIncome;
	private Integer days;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getDailyIncome() {
		return dailyIncome;
	}
	
	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	
	public Integer getDays() {
		return days;
	}
	
	public void setDays(Integer days) {
		this.days = days;
	}
	
	public Double getTotal() {
		return days * dailyIncome;
	}

}