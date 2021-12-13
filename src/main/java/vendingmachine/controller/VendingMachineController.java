package vendingmachine.controller;

import java.util.Map;
import java.util.Scanner;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Count;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private final InputView inputView;

	public VendingMachineController(Scanner scanner) {
		inputView = new InputView(scanner);
	}

	public int scanHoldingMoney() {
		return inputView.scanHoldingMoney();
	}

	public String[] scanProductNameAndPriceAndCnt() {
		return inputView.scanProductNameAndPriceAndCnt();
	}

	public int scanInputMoney() {
		return inputView.scanInputMoney();
	}

	public String scanBuyProductName() {
		return inputView.scanBuyProductName();
	}

	public void printHoldingCoins(final Map<Coin, Count> coins) {
		OutputView.printHoldingCoins(coins);
	}

	public void printInputMoney(int inputMoney) {
		OutputView.printInputMoney(inputMoney);
	}

	public void printChange(Map<Integer, Integer> changes) {
		OutputView.printChange(changes);
	}

	public static void printErrorNotHaveProduct() {
		OutputView.printErrorNotHaveProduct();
	}

	public static void printErrorProductPriceHigherThanInputMoney() {
		OutputView.printErrorProductPriceHigherThanInputMoney();
	}
}
