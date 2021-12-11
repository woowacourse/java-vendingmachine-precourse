package vendingmachine.controller;

import java.util.Map;
import java.util.Scanner;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Count;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	private final InputView inputView;

	public VendingMachineController(Scanner scanner) {
		inputView = new InputView(scanner);
	}

	public String scanHoldingMoney() {
		return inputView.scanHoldingMoney();
	}

	public String[] scanProductNameAndPriceAndCnt() {
		return inputView.scanProductNameAndPriceAndCnt();
	}

	public String scanInputMoney() {
		return inputView.scanInputMoney();
	}

	public void printHoldingCoins(final Map<Coin, Count> coins) {
		OutputView.printHoldingCoins(coins);
	}

	public void printInputMoney(int inputMoney) {
		OutputView.printInputMoney(inputMoney);
	}
}
