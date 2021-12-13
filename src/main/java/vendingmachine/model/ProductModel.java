package vendingmachine.model;

import vendingmachine.domain.MachineProducts;

public class ProductModel {
	private static MachineProducts products;

	public static void enrollProducts(String information) {
		products = new MachineProducts(information);
	}
}
