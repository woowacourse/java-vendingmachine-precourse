package vendingmachine.domain.machine;

import vendingmachine.domain.machine.coin.storage.CoinStorage;
import vendingmachine.domain.machine.product.Product;
import vendingmachine.domain.machine.product.storage.ProductStorage;

public class Machine {

	private CoinStorage coinStorage;
	private ProductStorage productStorage;

	public void saveProduct(Product product) {
		productStorage.save(product);
	}

}
