package com.kh.spring06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring06.entity.ItemDto;
import com.kh.spring06.repository.ItemDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
public class Test05 {
	
	@Autowired
	private ItemDao itemDao;
	
	@Test
	public void test() {
		ItemDto itemDto = new ItemDto();
		itemDto.setItemName("32인치모니터");
		itemDto.setItemPrice(170000);
		
		itemDao.insert(itemDto);
	}

}
