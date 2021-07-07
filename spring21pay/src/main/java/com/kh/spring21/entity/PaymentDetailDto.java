package com.kh.spring21.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PaymentDetailDto {
	private int paymentDetailNo;
	private int paymentDetailProduct;
	private int paymentDetailQuantity;
	private int paymentDetailAmount;
	private int paymentDetailOrigin;
}