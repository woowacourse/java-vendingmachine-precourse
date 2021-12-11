package vendingmachine.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
	private String name;
	private int price;
	private int quantity;

	public void reduceQuantity(int reduceValue) {
		this.quantity -= reduceValue;
	}

	public boolean compareToPrice(int money) {
		if (this.price <= money) {
			return true;
		}
		return false;
	}

	public boolean checkHaveStock() {
		return quantity > 0;
	}
}
