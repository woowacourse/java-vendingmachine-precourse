package productcase;

public class Product {
	private String name;
	private int price;
	private int stock;

	Product(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	protected boolean checkSameProduct(String name) {
		return this.name.equals(name);
	}

	protected boolean existStock() {
		if (stock > 0) {
			return true;
		}
		return false;
	}

	protected boolean checkEnoughToBuy(int inputMoney) {
		if (inputMoney >= price) {
			return true;
		}
		return false;
	}

	protected int sellOneProduct(int money) {
		stock -= 1;
		return money - price;
	}
}
