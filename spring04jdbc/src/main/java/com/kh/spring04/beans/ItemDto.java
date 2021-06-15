package com.kh.spring04.beans;

public class ItemDto {
	private int itemNo;
	private String itemName;
	private int itemPrice;
	@Override
	public String toString() {
		return "ItemDto [itemNo=" + itemNo + ", itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public ItemDto() {
		super();
	}
}