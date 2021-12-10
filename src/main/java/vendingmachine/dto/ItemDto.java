package vendingmachine.dto;

import vendingmachine.domain.item.Item;

public class ItemDto {
	private String itemName;
	private int itemPrice;
	private int itemQuantity;

	private ItemDto(String itemName, int itemPrice, int itemQuantity) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}

	public static ItemDto of(String itemName, int itemPrice, int itemQuantity) {
		return new ItemDto(itemName, itemPrice, itemQuantity);
	}

	public Item toEntity() {
		return Item.of(itemName, itemPrice, itemQuantity);
	}
}
