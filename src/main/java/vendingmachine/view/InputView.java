package vendingmachine.view;

import vendingmachine.exception.BalanceNotMultipleOfTenMessageException;
import vendingmachine.exception.BalanceNotNumericMessageException;
import vendingmachine.exception.BalanceNotPositiveMessageException;
import vendingmachine.view.reader.Reader;

public class InputView {

	private final Reader reader;
	private final OutputView outputView;

	public InputView(Reader reader, OutputView outputView) {
		this.reader = reader;
		this.outputView = outputView;
	}

	public int requestBalanceOfMachine() {
		outputView.printMessage("자판기가 보유하고 있는 금액을 입력해 주세요.");
		return getValidBalance();
	}

	private int getValidBalance() {
		String inputString = reader.readLine();
		int balance = convertBalanceStringToInteger(inputString);
		validateBalance(balance);
		return balance;
	}

	private int convertBalanceStringToInteger(String inputString) {
		try {
			return Integer.parseInt(inputString);
		} catch (NumberFormatException ex) {
			throw new BalanceNotNumericMessageException();
		}
	}

	private void validateBalance(int balance) {
		validateBalanceIsPositive(balance);
		validateBalanceIsMutipleOfTen(balance);
	}

	private void validateBalanceIsPositive(int balance) {
		if (isNumberNotPositive(balance)) {
			throw new BalanceNotPositiveMessageException();
		}
	}

	private boolean isNumberNotPositive(int number) {
		return (number <= 0);
	}

	private void validateBalanceIsMutipleOfTen(int balance) {
		if (isNumberNotMutipleOfTen(balance)) {
			throw new BalanceNotMultipleOfTenMessageException();
		}
	}

	private boolean isNumberNotMutipleOfTen(int number) {
		return (number % 10 != 0);
	}


}
