package vendingmachine.controller;

import static constant.CharacterConstant.*;
import static constant.NumberConstant.*;
import static constant.StringConstant.*;

import java.util.Map;

import exception.PriceException;
import vendingmachine.model.Coin;
import vendingmachine.repository.ProductRepository;
import vendingmachine.service.ProductRepositoryService;
import vendingmachine.service.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.PrintView;

public class ApplicationController {
	private VendingMachineService vendingMachineService;
	private ProductRepositoryService productRepositoryService;

	public ApplicationController(VendingMachineService vendingMachineService,
		ProductRepositoryService productRepositoryService) {
		this.vendingMachineService = vendingMachineService;
		this.productRepositoryService = productRepositoryService;
	}

	//vendingMachine에 productRepository주입
	public void startVendingMachine() {
		ProductRepository productRepository = productRepositoryService.getProductRepository();
		vendingMachineService.saveProductRepository(productRepository);

		saveBalance();
	}

	private void saveBalance() {
		String balance = InputView.getUserInput(VENDING_MACHINE_BALANCE_MESSAGE);
		try {
			vendingMachineService.saveBalance(balance);
			setCoinsByBalance(Integer.parseInt(balance));
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + BALANCE_PRICE_PREFIX + e.getMessage() + LINE_BREAK);
			startVendingMachine();
		}
	}

	private void setCoinsByBalance(int balance) {
		vendingMachineService.setVendingMachineCoins(balance);
		PrintView.printCoins(vendingMachineService.getCoinMap(), LINE_BREAK + COIN_CONTAIN_MESSAGE);

		saveProducts();
	}

	private void saveProducts() {
		String userProducts = InputView.getUserInput(LINE_BREAK + VENDING_MACHINE_PRODUCT_MESSAGE);
		try {
			productRepositoryService.saveProductRepository(userProducts);
			getMoney();
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + e.getMessage());
			saveProducts();
		}
	}

	private void getMoney() {
		String money = InputView.getUserInput(LINE_BREAK + INSERT_MONEY_MESSAGE);
		try {
			PriceException.isValidPrice(money);
			int validMoney = Integer.parseInt(money);
			getOrder(validMoney);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + INSERT_MONEY_PREFIX + e.getMessage());
			getMoney();
		}
	}

	private void getOrder(int money) {
		while (!shouldChange(money)) {
			money -= updateByOrder(money);
		}
		returnChange(money);
	}

	//잔돈 반환 유무 판단
	private boolean shouldChange(int money) {
		int minProductPrice = productRepositoryService.getMinPrice();
		int productStock = productRepositoryService.getStock();
		if (minProductPrice > money
				|| productStock == ZERO) {
			return true;
		}
		return false;
	}

	private int updateByOrder(int money) {
		try {
			PrintView.printMoneyState(money);
			String orderedProduct = InputView.getUserInput(ORDER_PRODUCT_MESSAGE);
			productRepositoryService.updateByOrder(orderedProduct, money);
			return productRepositoryService.getPriceByOrder(orderedProduct);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_PREFIX + e.getMessage());
		}
		return ZERO;
	}

	private void returnChange(int money) {
		PrintView.printMoneyState(money);
		Map<Coin, Integer> changeCoinSet = vendingMachineService.getChangeCoins(money);
		PrintView.printCoins(changeCoinSet, CHANGE);
	}

}
