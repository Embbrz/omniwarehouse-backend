package com.omniwarehouse_app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FullFillRequest(
		@JsonProperty("itemId") Long itemId,
		@JsonProperty("quantityRequested")Integer quantityRequested) {

}
