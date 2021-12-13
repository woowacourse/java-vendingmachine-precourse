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
		return findProductByName(name) != null;
	}

	public boolean productCountOverOne(String name) {
		return findProductByName(name).hasMoreThanOneCount();
	}

	public boolean canBuy(String name, long money) {
		return findProductByName(name).isCheaperOrSameThan(money);
	}

	private Product findProductByName(String name) {
		return products.stream()
			.filter(product -> product.isSameName(name))
			.findFirst().orElse(null);
	}

	private List<Product> makeProducts(String inputLine) {
		List<String> strings = ProductService.splitBySemicolon(inputLine);
		return strings.stream()
			.map(string -> Product.makeProduct(string))
			.collect(Collectors.toList());
	}
}
