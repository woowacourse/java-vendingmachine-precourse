package vendingmachine;

public class Product {

	private static final String ERROR_MSG_PURCHASE_PRODUCT_SOLD_OUT = "[ERROR] 재고 수량이 없는 재품입니다.";

	private String name;
	private int price;
	private int quantity;

	public Product(String productInfo) {
		String[] splitInfo = productInfo.split(",");
		this.name = splitInfo[0].trim();
		this.price = Integer.parseInt(splitInfo[1]);
		this.quantity = Integer.parseInt(splitInfo[2]);
	}

	public int getPrice() {
		return this.price;
	}

	public boolean isThisName(String input) {
		return this.name.equals(input);
	}

	public void isSoldOut() {
		if (this.quantity == 0) {
			throw new IllegalArgumentException(ERROR_MSG_PURCHASE_PRODUCT_SOLD_OUT);
		}
	}

	public void sellProduct() {
		this.quantity -= 1;
	}
}
