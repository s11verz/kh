package com.kh.spring05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.spring05.entity.ItemDto;
import com.kh.spring05.repository.ItemDao;

@Controller
public class ItemController {
	
	@Autowired
	private ItemDao itemDao;

	//@RequestMapping(value="/insert",method=RequestMethod.GET)
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
