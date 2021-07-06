package com.kh.spring21.repository;

import java.util.List;

import com.kh.spring21.entity.PaymentDto;

public interface PaymentDao {
	int getSequence();
	void ready(PaymentDto paymentDto);
	void approve(int paymentNo);
	List<PaymentDto> list(int paymentBuyer);
	PaymentDto get(int paymentNo);
	void cancel(int paymentNo);
}