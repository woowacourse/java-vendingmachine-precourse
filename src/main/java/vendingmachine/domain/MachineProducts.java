package vendingmachine.domain;

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

	public int getPrice(String name) {
		return findProductByName(name).getPrice();
	}

	public boolean allProductCountZero() {
		return products.stream().allMatch(product -> product.soldOut());
	}

	public boolean canBuyCheapest(long money) {
		return getCheapestProductNotSoldOut() <= money;
	}

	private Product findProductByName(String name) {
		return products.stream()
			.filter(product -> product.isSameName(name))
			.findFirst().orElse(null);
	}

	private List<Product> makeProducts(String inputLine) {
		List<String> strings = ProductService.splitProductsInformation(inputLine);
		return strings.stream()
			.map(string -> Product.makeProduct(string))
			.collect(Collectors.toList());
	}

	private int getCheapestProductNotSoldOut() {
		return products.stream()
			.filter(product -> !product.soldOut())
			.mapToInt(product -> product.getPrice())
			.min().getAsInt();
	}

	public void buyProduct(String name) {
		findProductByName(name).consume();
	}
}
