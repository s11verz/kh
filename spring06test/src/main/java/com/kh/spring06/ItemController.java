package com.kh.spring06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.spring06.entity.ItemDto;
import com.kh.spring06.repository.ItemDao;

@Controller
public class ItemController {
	
	@Autowired
	private ItemDao itemDao;

	@GetMapping("/insert")
	public String insert() {
		return "item/insert";
	}
	
	
	@PostMapping("/insert")
	public String insert(@ModelAttribute ItemDto itemDto) {
		itemDao.insert(itemDto);
		return "redirect:insert";
	}
}
