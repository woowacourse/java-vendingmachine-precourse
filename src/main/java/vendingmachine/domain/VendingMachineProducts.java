package vendingmachine.domain;

import static constants.VendingMachineConstants.*;

import java.util.List;

public class VendingMachineProducts {
	private final List<VendingMachineProduct> products;

	public VendingMachineProducts(List<VendingMachineProduct> products) {
		this.products = products;
	}

	public void buyProduct(String productName) {
		products.stream()
			.filter(tmpProduct -> tmpProduct.isSameName(productName))
			.findAny()
			.ifPresent(VendingMachineProduct::buy);
	}

	public Integer getLowestPrice() {
		int lowPrice = Integer.MAX_VALUE;
		for (VendingMachineProduct product : products) {
			lowPrice = Math.min(product.getPrice(), lowPrice);
		}
		return lowPrice;
	}

	public boolean hasProduct() {
		return (products.stream().anyMatch(VendingMachineProduct::isExist));
	}

	public VendingMachineProduct findName(String productName) {
		return products.stream()
			.filter(tmpProduct -> tmpProduct.isSameName(productName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(PRODUCT_NAME_NOT_EXIST_ERROR));
	}
}
