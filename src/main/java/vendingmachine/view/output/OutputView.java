package vendingmachine.view.output;

import java.util.List;
import vendingmachine.view.output.message.ErrorMessage;
import vendingmachine.view.output.message.OutputMessage;

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
		printMessage(OutputMessage.INTRO_COINS_OF_MACHINE);
		coinStrings.forEach(this::printMessage);
	}

	public void printCurrentMoneyOfUser(int currentMoneyOfUser) {
		printMessage(String.format(OutputMessage.MONEY_OF_USER_OUTPUT_FORMAT, currentMoneyOfUser));
	}
	
	public void printCoinsOfUser(List<String> coinStrings) {
		printMessage(OutputMessage.INTRO_COINS_OF_USER);
		coinStrings.forEach(this::printMessage);
	}

}
