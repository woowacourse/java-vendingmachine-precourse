package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.InputValidator;

public class VendingMachineInputView {
	private static final VendingMachineInputView vendingMachineInputView = new VendingMachineInputView();
	private final InputValidator inputValidator;

	private VendingMachineInputView() {
		inputValidator = InputValidator.getInputValidator();
	}

	public static VendingMachineInputView getVendingMachineInputView(){
		return vendingMachineInputView;
	}

	public int getInitialAmount() {
		String amount;
		do {
			amount = Console.readLine();
		}
		while (!inputValidator.checkInitialAmountInputExceptions(amount));
		return Integer.parseInt(amount);
	}
}
