package vendingmachine.domain.item;

public class Item {
	private static final String TO_STRING_FORMAT = "{ItemName=%s, ItemPrice=%s, ItemQuantity=%s}";

	private final ItemName name;
	private final ItemPrice price;
	private final ItemQuantity quantity;

	private Item(ItemName name, ItemPrice price, ItemQuantity quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public static Item of(String name, int price, int quantity) {
		ItemName itemName = ItemName.from(name);
		ItemPrice itemPrice = ItemPrice.from(price);
		ItemQuantity itemQuantity = ItemQuantity.from(quantity);

		return new Item(itemName, itemPrice, itemQuantity);
	}

	public ItemName getItemName() {
		return this.name;
	}

	public ItemPrice getItemPrice() {
		return this.price;
	}

	public boolean isSoldOut() {
		return this.quantity.toInt() <= 0;
	}

	// TODO: decreaseQuantity 로 변경 필요
	public Item buy() {
		ItemQuantity subtractedQuantity = this.quantity.subtract();
		return new Item(this.name, this.price, subtractedQuantity);
	}

	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, this.name.toString(), this.price.toString(), this.quantity.toString());
	}
}
