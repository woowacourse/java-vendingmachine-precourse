package vendingmachine.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static vendingmachine.view.Print.*;
import static vendingmachine.Validator.*;

import vendingmachine.domain.VendingMachine;

public class Consumer {
	private VendingMachine vendingMachine;

	public Consumer(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public String getMoney() {
		String input = readLine();
		input = validateMoney(input);

		return input;
	}

	private String validateMoney(String input) {
		try {
			validateMoneyNumber(input);
			validateMoneyOverZero(input);
			validateMoneyDividedByTen(input);
		} catch (Exception e) {
			printError(e.getMessage());
			input = getMoney();
		}
		return input;
	}

	public String selectProduct() {
		String input = readLine();
		input = validateSelectedProduct(input);

		return input;
	}

	private String validateSelectedProduct(String input) {
		try {
			validateSelectedProductEmpty(input);
		} catch (Exception e) {
			printError(e.getMessage());
			input = selectProduct();
		}
		return input;
	}
}
