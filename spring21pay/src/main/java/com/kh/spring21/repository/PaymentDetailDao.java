package com.kh.spring21.repository;

import java.util.List;

import com.kh.spring21.entity.PaymentDetailDto;

public interface PaymentDetailDao {
	void add(List<PaymentDetailDto> list);
	void addAll(List<PaymentDetailDto> list);
	List<PaymentDetailDto> get(int paymentDetailOrigin);
}