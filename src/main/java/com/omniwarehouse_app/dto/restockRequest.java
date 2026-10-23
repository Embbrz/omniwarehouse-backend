package com.omniwarehouse_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record restockRequest(
		@JsonProperty("itemId") Long id,
		@JsonProperty("quantityToAdd") Integer quantity
		) {

}
