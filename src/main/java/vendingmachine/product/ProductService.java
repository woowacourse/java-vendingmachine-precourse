package vendingmachine.product;

import vendingmachine.machine.Machine;

public class ProductService {

	public Product makeProduct(String product) {
		String[] infos = product.substring(1, product.length() - 1).split(",");
		return new Product(infos[0], Integer.valueOf(infos[1]), Integer.valueOf(infos[2]));
	}

	public Product buyProduct(Machine machine, String productName) {
		Product product = Product.findProduct(machine, productName);
		product.buy();
		return product;
	}
}
