package vendingmachine.domain;

import static constants.VendingMachineConstants.*;

public class VendingMachineProduct {
	private final String name;
	private final Integer price;
	private Integer amount;

	public VendingMachineProduct(String name, Integer price, Integer amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public Integer getPrice() {
		return price;
	}

	public boolean isSameName(String name) {
		return this.name.equals(name);
	}

	public void buy() {
		if (amount == 0) {
			throw new IllegalArgumentException(PRODUCT_NOT_EXIST_ERROR);
		}
		amount -= 1;
	}

	public boolean isExist() {
		return amount != 0;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof VendingMachineProduct) || o.getClass() != getClass()) {
			return false;
		}
		VendingMachineProduct vendingMachineProduct = (VendingMachineProduct)o;
		return vendingMachineProduct.isSameName(name);
	}
}
