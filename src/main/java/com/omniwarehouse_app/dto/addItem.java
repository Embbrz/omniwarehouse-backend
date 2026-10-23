package com.omniwarehouse_app.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record addItem(
		@JsonProperty("sku") String sku,
		@JsonProperty("itemName") String itemName,
		@JsonProperty("unitPrice") BigDecimal unitPrice,
		@JsonProperty("quantityAvailable") Integer quantity,
		@JsonProperty("category") String category
		
		) {

}
