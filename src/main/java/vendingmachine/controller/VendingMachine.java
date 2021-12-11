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
		// TODO : 상품 구매하기
	}

	private void init() {
		initCoinStorage();
		// TODO : 상품 입력 받기
		// TODO : 투입 금액 입력 받기
	}

	private void initCoinStorage() {
		// TODO : 자판기 보유 금액 입력받기
		vendingService.initCoinStorage(inputManager.getStorageMoney());
		// TODO : 자판기 보유 동전 알려주기
		notifyStorageCoin();
	}

	private void notifyStorageCoin() {
		outputManager.notifyStorageCoinStart();
		for(Coin coin : Coin.values()) {
			int quantity = vendingService.getCoinStorageQuantity(coin);
			outputManager.notifyStorageCoinInLine(coin, quantity);
		}
	}

}
