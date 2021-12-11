package vendingmachine.service;

import java.util.EnumMap;
import java.util.List;

import vendingmachine.constants.OutputConstants;
import vendingmachine.domain.CoinStorage;
import vendingmachine.domain.Product;
import vendingmachine.domain.UserBalance;
import vendingmachine.enums.Coin;
import vendingmachine.manager.ProductManager;

public class VendingService {
	private CoinStorage coinStorage;
	private UserBalance userBalance;
	private ProductManager productManager;

	public VendingService() {
		this.productManager = new ProductManager();
	}

	public void initCoinStorage(int coinMoney) {
		this.coinStorage = new CoinStorage(coinMoney);
	}

	public void initProducts(List<Product> products) {
		productManager.addAllProduct(products);
	}

	public void initUserBalance(int userBalance) {
		this.userBalance = new UserBalance(userBalance);
	}

	public int getCoinStorageQuantity(Coin coin) {
		return coinStorage.getCoinQuantity(coin);
	}

	public boolean checkProductExist(String name) {
		try {
			productManager.checkProductExist(name);
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	public boolean buyProduct(String name) {
		Product product = productManager.searchProduct(name);
		if(!product.compareToPrice(userBalance.getUserBalance()) || !product.checkHaveStock()) {
			return false;
		}
		product.reduceQuantity(1);
		userBalance.deductBalance(product.getPrice());
		return true;
	}

	public EnumMap<Coin, Integer> makeChange() {
		return coinStorage.getChange(userBalance.getUserBalance());
	}
}
