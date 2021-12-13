package vendingmachine.domain;

import java.util.LinkedHashSet;
import java.util.Set;

public class ProductSet {

	public static final String NAME = "상품목록";
	private static final String ERROR_NO_PRODUCT = "상품명 %s 가 존재하지 않습니다.";
	private Set<Product> products;

	public ProductSet() {
		this.products = new LinkedHashSet<>();
	}

	public ProductSet(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return products.toString();
	}

	public Price purchase(final Name name) {
		Product product = products.stream()
			.filter(products -> products.matchName(name))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException(String.format(ERROR_NO_PRODUCT, name)));
		return product.purchase();
	}

	public boolean isAvailable(final Money money) {
		if (isAllProductSoldOut()) {
			return false;
		}
		return isAnyPurchasable(money);
	}

	private boolean isAllProductSoldOut() {
		return products.stream().noneMatch(Product::isQuantityEnough);
	}

	private boolean isAnyPurchasable(final Money money) {
		return products.stream().anyMatch(product -> product.isPurchasable(money));
	}
}
