package vendingmachine.service;

import vendingmachine.domain.VendingMachine;
import vendingmachine.validator.InputValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class InputService {
	private final InputValidator validator = new InputValidator();

	public int readAmount() {
		while (true) {
			try {
				OutputView.print_inputAmount();
				int amount = validator.isPositiveNumber(InputView.getAmount());
				validator.isPossibleMod(amount);
				return amount;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public int readMoney() {
		while (true) {
			try {
				OutputView.print_inputMoney();
				int money = validator.validateMoney(InputView.getAmount());
				return money;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String readProductName(int money, VendingMachine machine) {
		OutputView.print_money(money);
		OutputView.print_input_ProduntName();
		String name = InputView.getProductName();

		validator.isExist(name, money, machine);

		return name;
	}

}
