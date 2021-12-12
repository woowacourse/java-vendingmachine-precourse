package vendingmachine.domain.product;

import vendingmachine.validator.ProductValidator;

public class ProductName {
	private final String name;

	public ProductName(String name) {
		ProductValidator.checkProductName(name);
		this.name = name;
	}

	public boolean equals(ProductName o) {
		return name.equals(o.name);
	}
}
