package vendingmachine.domain;

import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.utils.Constant;
import vendingmachine.utils.Message;

public class Products {
	private final List<Product> products;

	public Products(List<String> list) {
		this.products = list.stream()
			.map(element -> {
				String[] splited = element.split(Constant.PRODUCT_INFO_DELIMETER);
				return Product.of(splited[Constant.CONSTANT_ZERO], splited[Constant.CONSTANT_ONE],
					splited[Constant.CONSTANT_TWO]);
			})
			.collect(Collectors.toList());
	}

	public static Products from(List<String> list) {
		return new Products(list);
	}

	public List<Product> toList() {
		return this.products;
	}

	public Product findProductByName(String inputValue) {
		return this.products.stream()
			.filter(product -> product.toName().equals(Name.of(inputValue)))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(Message.REQUEST_MESSAGE_THERE_IS_NO_PRODUCT));
	}

	public int findMinAmount() {
		return this.products.stream()
			.mapToInt(Product::toAmount)
			.min()
			.orElse(Constant.CONSTANT_ZERO);
	}
}
