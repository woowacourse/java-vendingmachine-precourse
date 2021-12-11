package vendingmachine.view;

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

}
