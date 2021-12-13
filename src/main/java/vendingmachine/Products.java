package vendingmachine;

public class Products extends Remaining<Product> {
	private int minimumPrice = Integer.MAX_VALUE;

	public int getMinPrice() {
		minimumPrice = Integer.MAX_VALUE;
		this.keySet().forEach(this::changeMinPrice);
		return minimumPrice;
	}

	private void changeMinPrice(Product product) {
		int thisPrice = product.getPrice();
		if (thisPrice <= minimumPrice && !isEmpty(product)) {
			minimumPrice = thisPrice;
		}
	}
}
