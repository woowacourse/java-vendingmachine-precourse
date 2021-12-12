package vendingmachine.dto;

import vendingmachine.domain.Change;

public class ResponseChangeDto {
	private Change change;

	public ResponseChangeDto(Change change) {
		this.change = change;
	}

	public Change getChange() {
		return change;
	}
}
