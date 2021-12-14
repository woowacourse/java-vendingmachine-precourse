package vendingmachine.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Products {
	private List<Product> products;

	public Products(List<String> list) {
		this.products = list.stream()
			.map(element -> {
				String[] splited = element.split(",");
				return Product.of(splited[0], splited[1], splited[2]);
			})
			.collect(Collectors.toList());
	}

	public static Products from(List<String> list) {
		return new Products(list);
	}

	public boolean isContains(Product product) {
		return this.products.contains(product);
	}

	public List<Product> toList() {
		return this.products;
	}

	public Product findProductByName(String inputValue) {
		return this.products.stream()
			.filter(product -> product.toName().equals(Name.of(inputValue)))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("해당 상품은 존재하지 않습니다."));
	}

	public int findMinAmount() {
		return this.products.stream()
			.mapToInt(Product::toAmount)
			.min()
			.orElse(0);
	}
}
