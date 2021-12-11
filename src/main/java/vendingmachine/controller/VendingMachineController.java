package vendingmachine.controller;

import java.util.Scanner;

import vendingmachine.domain.Coins;
import vendingmachine.view.InputView;

public class VendingMachineController {
	private final InputView inputView;

	public VendingMachineController(Scanner scanner) {
		inputView = new InputView(scanner);
	}

	public String scanHoldingMoney() {
		return inputView.scanHoldingMoney();
	}
}
