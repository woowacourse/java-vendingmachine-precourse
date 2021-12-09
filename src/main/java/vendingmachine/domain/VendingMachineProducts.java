package vendingmachine.domain;

import java.util.List;

public class VendingMachineProducts {
	private final List<VendingMachineProduct> products;

	public VendingMachineProducts(List<VendingMachineProduct> products) {
		this.products = products;
	}
}
