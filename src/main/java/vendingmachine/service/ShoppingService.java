package vendingmachine.service;

import static vendingmachine.constant.ErrorMessage.*;

import java.util.Comparator;
import java.util.NoSuchElementException;

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

	public int getMinimumPrice() {
		Comparator<Product> comparatorByPrice = Comparator.comparingInt(Product::getPrice);
		return products.getProducts().stream()
			.min(comparatorByPrice)
			.orElseThrow(NoSuchElementException::new).getPrice();
	}

	public boolean canShopping() {
		return isOverZeroAllProductCount() && insertMoney.isMoneyBiggerThanValue(getMinimumPrice());
	}

	public boolean isOverZeroAllProductCount() {
		return 0 < products.getProducts().stream().mapToInt(Product::getQuantity).sum();
	}

	public void purchase(String productName) {
		Product product = findByName(productName);
		product.purchase();
		insertMoney.subtractMoney(product.getPrice());
	}

	private Product findByName(String productName) {
		return products.getProducts().stream()
			.filter(product -> product.getName().equals(productName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(PRODUCT_NOT_EXIST_MSG));
	}

	public boolean canSell(String productName) {
		Product product = findByName(productName);
		return product.isOverZeroQuantity() && product.isPurchase(insertMoney.getMoney());

	}
}
