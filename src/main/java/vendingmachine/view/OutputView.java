package vendingmachine.view;

import java.util.List;
import vendingmachine.resource.ErrorMessage;

public class OutputView {

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printErrorMessage(String message) {
		printMessage(ErrorMessage.TAG + message);
	}

	public void printEmptyNewLine() {
		System.out.println();
	}

	public void printCoinsOfMachine(List<String> coinStrings) {
		printMessage("자판기가 보유한 동전");
		coinStrings.forEach(this::printMessage);
	}

	public void printCurrentMoneyOfUser(int currentMoneyOfUser) {
		printMessage(String.format("투입 금액: %d원", currentMoneyOfUser));
	}

}
