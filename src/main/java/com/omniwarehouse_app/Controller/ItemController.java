package com.omniwarehouse_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.omniwarehouse_app.Service.ItemService;

@RestController
public class ItemController {
	
	
	private ItemService itemService;
	
	@Autowired
	public ItemController(ItemService ii) {
		this.itemService = ii;
	}

}
