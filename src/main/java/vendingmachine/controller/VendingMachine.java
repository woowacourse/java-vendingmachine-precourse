package vendingmachine.controller;

import java.util.EnumMap;

import vendingmachine.manager.CoinStorage;
import vendingmachine.domain.Product;
import vendingmachine.domain.UserBalance;
import vendingmachine.enums.Coin;
import vendingmachine.manager.ProductManager;
import vendingmachine.view.InputManager;
import vendingmachine.view.OutputManager;

public class VendingMachine {
	private CoinStorage coinStorage;
	private UserBalance userBalance;
	private ProductManager productManager;
	private final InputManager inputManager;
	private final OutputManager outputManager;

	public VendingMachine() {
		inputManager = new InputManager();
		outputManager = new OutputManager();
	}

	public void start() {
		init();
		buyProducts();
		getChange();
	}

	private void init() {
		initCoinStorage();
		initProductList();
		initUserBalance();
	}

	private void initCoinStorage() {
		coinStorage = new CoinStorage(inputManager.getStorageMoney());
		notifyStorageCoin();
	}

	private void notifyStorageCoin() {
		outputManager.notifyStorageCoinStart();
		for(Coin coin : Coin.values()) {
			int quantity = coinStorage.getCoinQuantity(coin);
			outputManager.notifyQuantityByCoin(coin, quantity);
		}
	}

	private void initProductList() {
		productManager = new ProductManager(inputManager.getProductList());
	}

	private void initUserBalance() {
		userBalance = new UserBalance(inputManager.getUserBalance());
	}

	private void buyProducts() {
		while(true) {
			outputManager.notifyUserBalance(userBalance.getUserBalance());
			if(!productManager.checkCanBuyProduct(userBalance.getUserBalance())) {
				return;
			}
			String productName = inputManager.getProductName();
			if(!checkProductExist(productName)) {
				continue;
			}
			buyProduct(productName);
		}
	}

	private boolean checkProductExist(String productName) {
		try {
			productManager.checkProductExist(productName);
		} catch (IllegalArgumentException e) {
			inputManager.print(e.getMessage());
			return false;
		}
		return true;
	}

	private void buyProduct(String name) {
		Product product = productManager.searchProduct(name);

		product.reduceQuantity(1);
		userBalance.deductBalance(product.getPrice());
	}

	private void getChange() {
		outputManager.notifyChangeStart();
		EnumMap<Coin, Integer> changeMap = coinStorage.getChange(userBalance.getUserBalance());
		outputManager.notifyChange(changeMap);
	}
}
