package com.kh.spring04.beans;

import java.util.List;

public interface ItemDao {

	
	void insert(ItemDto itemDto) throws Exception;
	List<ItemDto> list() throws Exception;
	ItemDto get(int itemNo) throws Exception;
	boolean delete(int itemNo) throws Exception;
	boolean editPrice(ItemDto itemDto) throws Exception;
	boolean edit(ItemDto itemDto) throws Exception;
	int sequence() throws Exception;
	void insert2(ItemDto itemDto) throws Exception;
}
