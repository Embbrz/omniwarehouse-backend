package com.omniwarehouse_app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.omniwarehouse_app.Entity.Item;
import com.omniwarehouse_app.Repository.ItemRepo;

@Service
public class ItemService {
	
	
	private ItemRepo itemrepo;
	
	@Autowired
	public ItemService(ItemRepo ii) {
		this.itemrepo = ii;
	}
	
	public Page<Item> getInventory(Pageable pageable){
		return itemrepo.findAll(pageable);
	}
	


}
