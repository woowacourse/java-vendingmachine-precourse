package vendingmachine.firstclass;

import vendingmachine.model.Product;

import java.util.ArrayList;
import java.util.List;

import static vendingmachine.message.Error.NOT_ENOUGH_TO_BUY;
import static vendingmachine.message.Error.NO_SUCH_PRODUCT_EXIST;

public class Products {

	private List<Product> products = new ArrayList<>();

	public Products(List<Product> products) {
		this.products = products;
	}

	public int sellProduct(String name, int money) {
		Product product = getProductByName(name);
		return countOutProduct(product, money);
	}

	public boolean anyAvailableRemain(int money) {
		return checkAnyProductRemain() && checkCanBuyCheapest(money);
	}

	private Product getProductByName(String name) {
		return products.stream()
				.filter(product -> product.getName().equals(name))
				.findAny()
				.orElseThrow(() -> new IllegalArgumentException(NO_SUCH_PRODUCT_EXIST));
	}

	private int countOutProduct(Product product, int money) {
		if (!product.enoughMoneyToBuy(money)) {
			throw new IllegalArgumentException(NOT_ENOUGH_TO_BUY);
		}
		return product.purchaseOne(money);
	}

	private boolean checkAnyProductRemain() {
		return products.stream()
				.anyMatch(product -> product.isStockRemain() == true);
	}

	private boolean checkCanBuyCheapest(int money) {
		return products.stream()
				.anyMatch(product -> product.enoughMoneyToBuy(money));
	}
}
