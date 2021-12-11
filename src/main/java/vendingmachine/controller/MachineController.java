package vendingmachine.controller;

import vendingmachine.input.MachineInput;
import vendingmachine.model.Product;
import vendingmachine.util.ProductBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class MachineController {
	public List<Product> getProducts() {
		MachineInput machineInput = new MachineInput();
		List<String> productsInfo = machineInput.getProductsInfo();
		List<Product> products = makeProductsFromInfo(productsInfo);
		return products;
	}

	private List<Product> makeProductsFromInfo(List<String> productsInfo) {
		ProductBuilder productBuilder = new ProductBuilder();
		List<Product> products = productsInfo.stream()
				.map(p -> productBuilder.makeProductFromInfo(p))
				.collect(Collectors.toList());
		return products;
	}
}
