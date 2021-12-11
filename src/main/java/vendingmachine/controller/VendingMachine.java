package vendingmachine.controller;

import java.util.EnumMap;

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
		// buyProduct();
	}

	private void init() {
		initCoinStorage();
		initProductList();
		// initUserBalance();
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
		while(true) {
			outputManager.notifyUserBalance(vendingService.getUserBalance());
			String productName = inputManager.getProductName();
			if(!checkProductExist(productName)) {
				continue;
			}
			if(!vendingService.buyProduct(productName)) {
				break;
			}
			// TODO : 투입 금액으로 살 수 있는 물건이 없는 경우 break
		}
		getChange();
	}

	private boolean checkProductExist(String name) {
		boolean exist = vendingService.checkProductExist(name);
		if(!exist) {
			//TODO : error message
		}
		return exist;
	}

	private void getChange() {
		EnumMap<Coin, Integer> changeMap = vendingService.makeChange();
		outputManager.notifyChange(changeMap);
	}
}
