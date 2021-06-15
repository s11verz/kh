package com.kh.spring04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring04.beans.ItemDao;
import com.kh.spring04.beans.ItemDaoImpl;
import com.kh.spring04.beans.ItemDto;

@Controller
public class ItemController {
	
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/list")
	public String list(Model model) throws Exception {
		ItemDaoImpl itemDao=new ItemDaoImpl();
		List<ItemDto> list=itemDao.list();
		
		model.addAttribute("list",list);
		
		return "list";
	}
}
