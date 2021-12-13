package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.service.ProductService;

public class MachineProducts {
	List<Product> products;

	public MachineProducts(String inputLine) {
		products = makeProducts(inputLine);
	}

	public boolean hasName(String name) {
		return products.stream().anyMatch(product -> product.isSameName(name));
	}

	public boolean productCountOverOne(String name) {
		return products.stream()
			.filter(product -> product.isSameName(name))
			.allMatch(product -> product.hasMoreThanOneCount());
	}

	private List<Product> makeProducts(String inputLine) {
		List<String> strings = ProductService.splitBySemicolon(inputLine);
		return strings.stream()
			.map(string -> Product.makeProduct(string))
			.collect(Collectors.toList());
	}
}
