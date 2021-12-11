package vendingmachine;

public class Product {

	private String name;
	private int price;
	private int quantity;

	public Product(String productInfo) {
		String[] splitInfo = productInfo.split(",");
		this.name = splitInfo[0];
		this.price = Integer.parseInt(splitInfo[1]);
		this.quantity = Integer.parseInt(splitInfo[2]);
	}
}
