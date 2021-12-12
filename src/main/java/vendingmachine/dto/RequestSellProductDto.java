package vendingmachine.dto;

import vendingmachine.domain.Name;

public class RequestSellProductDto {
	private Name name;

	public RequestSellProductDto(Name name) {
		this.name = name;
	}

	public Name getName() {
		return name;
	}
}
