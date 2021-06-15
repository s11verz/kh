package com.kh.spring04.beans;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImpl2 implements ItemDao{
	

	@Override
	public void insert(ItemDto itemDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ItemDto> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDto get(int itemNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int itemNo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editPrice(ItemDto itemDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean edit(ItemDto itemDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int sequence() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insert2(ItemDto itemDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
