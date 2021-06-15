package com.kh.spring05.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring05.entity.ItemDto;

@Repository
public class ItemDaoImpl implements ItemDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate=new JdbcTemplate();
	
	@Override
	public void insert(ItemDto itemDto) {
		String sql="insert into values(item_seq.nextval,?,?)";
		Object[] param= {itemDto.getItemName(),itemDto.getItemPrice()};
		jdbcTemplate.update(sql,param);

		
		}

	
}
