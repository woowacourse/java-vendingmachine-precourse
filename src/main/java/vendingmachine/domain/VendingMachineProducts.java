package vendingmachine.domain;

import static constants.VendingMachineConstants.*;

import java.util.Comparator;
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
		return products.stream()
			.filter(VendingMachineProduct::isExist)
			.map(VendingMachineProduct::getPrice)
			.min(Comparator.naturalOrder())
			.orElseThrow(()->new IllegalArgumentException(PRODUCT_LOWEST_PRICE_NOT_FOUND_ERROR));
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
