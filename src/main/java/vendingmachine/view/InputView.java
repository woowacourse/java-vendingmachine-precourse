package vendingmachine.view;

import vendingmachine.exception.MoneyNotMultipleOfTenMessageException;
import vendingmachine.exception.MoneyNotNumericMessageException;
import vendingmachine.exception.MoneyNotPositiveMessageException;
import vendingmachine.view.reader.Reader;

public class InputView {

	private final Reader reader;
	private final OutputView outputView;

	public InputView(Reader reader, OutputView outputView) {
		this.reader = reader;
		this.outputView = outputView;
	}

	public int requestMoneyOfMachine() {
		outputView.printMessage("자판기가 보유하고 있는 금액을 입력해 주세요.");
		return getValidMoney();
	}

	private int getValidMoney() {
		String inputString = reader.readLine();
		int money = convertMoneyStringToInteger(inputString);
		validateMoney(money);
		return money;
	}

	private int convertMoneyStringToInteger(String inputString) {
		try {
			return Integer.parseInt(inputString);
		} catch (NumberFormatException ex) {
			throw new MoneyNotNumericMessageException();
		}
	}

	private void validateMoney(int balance) {
		validateMoneyIsPositive(balance);
		validateMoneyIsMultipleOfTen(balance);
	}

	private void validateMoneyIsPositive(int balance) {
		if (isNumberNotPositive(balance)) {
			throw new MoneyNotPositiveMessageException();
		}
	}

	private boolean isNumberNotPositive(int number) {
		return (number <= 0);
	}

	private void validateMoneyIsMultipleOfTen(int balance) {
		if (isNumberNotMultipleOfTen(balance)) {
			throw new MoneyNotMultipleOfTenMessageException();
		}
	}

	private boolean isNumberNotMultipleOfTen(int number) {
		return (number % 10 != 0);
	}

	public int requestMoneyOfUser() {
		outputView.printMessage("투입 금액을 입력해 주세요.");
		return getValidMoney();
	}

}
