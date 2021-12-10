package vendingmachine.dto;

import vendingmachine.domain.item.ItemName;

public class ItemNameDto {
	private String itemName;

	private ItemNameDto(String itemName) {
		this.itemName = itemName;
	}

	public static ItemNameDto from(String itemName) {
		return new ItemNameDto(itemName);
	}

	public ItemName toEntity() {
		return ItemName.from(itemName);
	}
}
