package vendingmachine.domain.machine;

import java.util.List;

import vendingmachine.domain.machine.coin.Coin;
import vendingmachine.domain.machine.coin.storage.CoinStorage;
import vendingmachine.domain.machine.coin.storage.CoinStorageImpl;
import vendingmachine.domain.machine.product.Product;
import vendingmachine.domain.machine.product.storage.ProductStorage;
import vendingmachine.domain.machine.product.storage.ProductStorageImpl;
import vendingmachine.domain.user.Balance;
import vendingmachine.domain.user.User;

public class Machine {

	private CoinStorage coinStorage = new CoinStorageImpl();
	private ProductStorage productStorage = new ProductStorageImpl();

	public void saveCoin(Coin coin) {
		coinStorage.save(coin);
	}

	public void saveProducts(List<Product> products) {
		productStorage.save(products);
	}

	public void purchaseProduct(Balance balance, String productName) {
		Product product = productStorage.findOne(productName);
		product.sell(balance);
	}

	public void refund(User user) {
		coinStorage.refund(user);
	}

	public List<String> getCoinsByString() {
		return coinStorage.getAllCoinsAsString();
	}

	public boolean isAllProductSoldOut() {
		return productStorage.isAllSoldOut();
	}

	public boolean isPossibleToUseWith(Balance balance) {
		return productStorage.isPossibleToUseWith(balance);
	}

}
