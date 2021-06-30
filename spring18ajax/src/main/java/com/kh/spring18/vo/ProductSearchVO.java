package com.kh.spring18.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductSearchVO {
	private int no;
	private String name, type;
	private int minPrice, maxPrice;
	private String made, expire;

}
