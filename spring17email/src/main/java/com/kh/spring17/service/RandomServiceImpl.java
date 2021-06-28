package com.kh.spring17.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomServiceImpl implements RandomService {

	@Override
	public String generateCertification(int size) {
		Random r = new Random();
		StringBuffer buffer = new StringBuffer();
		
		for(int i=0; i < size; i++) {
			int n = r.nextInt(10);//0~9
			buffer.append(n);
		}
		
		return buffer.toString();
	}
	
}