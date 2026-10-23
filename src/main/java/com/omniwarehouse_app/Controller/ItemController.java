package com.omniwarehouse_app.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omniwarehouse_app.Entity.Item;
import com.omniwarehouse_app.Service.ItemService;
import com.omniwarehouse_app.dto.FullFillRequest;
import com.omniwarehouse_app.dto.addItem;
import com.omniwarehouse_app.dto.restockRequest;


@RestController
@RequestMapping("/api/inventory-items")
public class ItemController {
	
	
	private ItemService itemService;
	
	@Autowired
	public ItemController(ItemService ii) {
		this.itemService = ii;
	}
	
	@GetMapping
	public Page<Item> getInventory(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
		
		return this.itemService.getInventory(pageable);
		
	}
	
	@GetMapping("/{id}")
	public Item getItem(@PathVariable Long id) {
		return this.itemService.getItem(id);
	}
	
	@PutMapping("/fulfill")
	public Item fullfillOrder(@RequestBody FullFillRequest request) {
		return this.itemService.fullfillOrder(request.itemId(), request.quantityRequested());
	}
	
	@PutMapping("/restock")
	public Item restockItem(@RequestBody restockRequest request) {
		return this.itemService.restockItem(request.id(), request.quantity());
	}
	
	@PostMapping("/addItem/")
	public Item addItem(@RequestBody addItem addItem) {
		return this.itemService.addItem(addItem.sku(), addItem.itemName(), addItem.unitPrice(), addItem.quantity(), addItem.category());
	}
		
	

}
