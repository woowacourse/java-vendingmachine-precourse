package vendingmachine.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static vendingmachine.view.Print.*;
import static vendingmachine.Validator.*;

import vendingmachine.domain.VendingMachine;

public class Administrator {
	private VendingMachine vendingMachine;

	public Administrator(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public String getMoneyOfChanges() {
		String input = readLine();
		input = validateMoneyOfChanges(input);

		return input;
	}

	private String validateMoneyOfChanges(String input) {
		try {
			validateNumber(input);
			validateOverZero(input);
			validateDividedByTen(input);
		} catch (Exception e) {
			printError(e.getMessage());
			input = getMoneyOfChanges();
		}

		return input;
	}

	// 자판기가 판매하는 상품 정보 입력
}
