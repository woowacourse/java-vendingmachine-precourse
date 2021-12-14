package vendingmachine.service;

import vendingmachine.model.Money;
import vendingmachine.model.Product;
import vendingmachine.model.Products;

public class ShoppingService {

	private Products products;
	private Money insertMoney;

	public void createProducts(String productList) {
		products = new Products(productList);
	}

	public void createInsertMoney(int money) {
		insertMoney = new Money(money);
	}

	public int getInsertMoney() {
		return insertMoney.getMoney();
	}

	public boolean canShopping() {
		return products.isOverZeroAllProductCount() && insertMoney.isMoneyBiggerThanValue(products.getMinimumPrice());
	}

	public void purchase(String productName) {
		Product product = products.findByName(productName);
		product.purchase();
		insertMoney.subtractMoney(product.getPrice());
		resetProducts(product);
	}

	private void resetProducts(Product product) {
		if (!product.isOverZeroQuantity()) {
			products.removeProduct(product);
		}
	}

	public boolean canSell(String productName) {
		Product product = products.findByName(productName);
		return product.isOverZeroQuantity() && product.isPurchase(insertMoney.getMoney());

	}
}
