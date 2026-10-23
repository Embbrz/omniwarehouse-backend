package com.omniwarehouse_app.Service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.omniwarehouse_app.Entity.Item;
import com.omniwarehouse_app.Repository.ItemRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemService {
	
	
	private ItemRepo itemrepo;
	
	@Autowired
	public ItemService(ItemRepo ii) {
		this.itemrepo = ii;
	}
	
	public Page<Item> getInventory(Pageable pageable){
		return itemrepo.findAll(pageable);
	}
	
	public Item getItem(Long id) {
		return itemrepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Item not found with " + id));
	}
	
	public Item fullfillOrder(Long id, Integer quantity) {
		
		Item item = this.getItem(id);
		
		if (item.getQuantityAvailable() >= quantity) {
			item.setQuantityAvailable(item.getQuantityAvailable() - quantity);
			
			return itemrepo.save(item);
		}
	
		throw new RuntimeException("Only " + item.getQuantityAvailable() +" " + item.getItemName() +" Available");
		
		
	}
	
	
	public Item restockItem(Long id, Integer quantity) {
		Item item = this.getItem(id);
		if ((quantity < 0)||(quantity > 200)) {
			throw new RuntimeException("Invalid Amount to Add");
		}
		item.setQuantityAvailable(item.getQuantityAvailable() + quantity);
		
		return itemrepo.save(item);
	}
	
	public Item addItem(String sku, String itemName, BigDecimal unitPrice, Integer quantity, String category) {
		Item item = new Item();
		item.setItemName(itemName);
		item.setSku(sku);
		item.setUnitPrice(unitPrice);
		item.setQuantityAvailable(quantity);
		item.setCategory(category);
		
		
		return itemrepo.save(item);
	}


}
