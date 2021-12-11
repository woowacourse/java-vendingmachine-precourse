package vendingmachine.controller;

import vendingmachine.enums.Coin;
import vendingmachine.service.VendingService;
import vendingmachine.view.InputManager;
import vendingmachine.view.OutputManager;

public class VendingMachine {
	private final VendingService vendingService;
	private final InputManager inputManager;
	private final OutputManager outputManager;

	public VendingMachine() {
		vendingService = new VendingService();
		inputManager = new InputManager();
		outputManager = new OutputManager();
	}

	public void start() {
		init();
		buyProduct();
	}

	private void init() {
		initCoinStorage();
		initProductList();
		initUserBalance();
	}

	private void initCoinStorage() {
		vendingService.initCoinStorage(inputManager.getStorageMoney());
		notifyStorageCoin();
	}

	private void notifyStorageCoin() {
		outputManager.notifyStorageCoinStart();
		for(Coin coin : Coin.values()) {
			int quantity = vendingService.getCoinStorageQuantity(coin);
			outputManager.notifyStorageCoinInLine(coin, quantity);
		}
		outputManager.printLine();
	}

	private void initProductList() {
		vendingService.initProducts(inputManager.getProductList());
	}

	private void initUserBalance() {
		vendingService.initUserBalance(inputManager.getUserBalance());
	}

	private void buyProduct() {

	}

}
