package vendingmachine.domain.item;

public class Item {
	private static final String TO_STRING_FORMAT = "{ItemName=%s, ItemPrice=%s, ItemQuantity=%s}";

	private static final int SOLD_OUT_QUANTITY = 0;

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
		return name;
	}

	public ItemPrice getItemPrice() {
		return price;
	}

	public boolean isSoldOut() {
		return quantity.toInt() <= SOLD_OUT_QUANTITY;
	}

	public Item decreaseQuantity() {
		ItemQuantity subtractedQuantity = quantity.subtract();
		return new Item(name, price, subtractedQuantity);
	}

	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, name.toString(), price.toString(), quantity.toString());
	}
}
