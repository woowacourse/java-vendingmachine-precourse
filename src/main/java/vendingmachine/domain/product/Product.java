package vendingmachine.domain.product;

import static vendingmachine.constant.SystemMessage.*;

import vendingmachine.validator.AmountValidator;
import vendingmachine.validator.ProductValidator;

public class Product {
	private ProductName name;
	private ProductAmount amount;
	private ProductStock stock;

	public Product(String unprocessedProduct) {
		ProductValidator.checkProduct(unprocessedProduct);
		String[] processedProduct = unprocessedProduct.substring(1, unprocessedProduct.length() - 1)
			.split(NAME_COST_STOCK_DELIMITER);
		int amount = AmountValidator.toInteger(processedProduct[AMOUNT]);
		int stock = AmountValidator.toInteger(processedProduct[STOCK]);

		this.name = new ProductName(processedProduct[NAME]);
		this.amount = new ProductAmount(amount);
		this.stock = new ProductStock(stock);
	}

	public boolean equals(Product o) {
		return name.equals(o.name);
	}
}
