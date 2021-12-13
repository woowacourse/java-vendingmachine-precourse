package vendingmachine.view.classes;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.constant.ExceptionConstant.*;
import static vendingmachine.constant.PromptConstant.*;

import vendingmachine.constant.VendingMachineStatus;
import vendingmachine.exception.InvalidUserInputException;
import vendingmachine.exception.NegativeUserInputException;
import vendingmachine.view.VendingMachine;

public class VendingMachineUI implements VendingMachine {
	VendingMachineStatus vendingMachineStatus = VendingMachineStatus.INPUT_MONEY_IN_VENDING_MACHINE;
	@Override
	public void start() {
		while (true) {
			if (vendingMachineStatus == VendingMachineStatus.INPUT_MONEY_IN_VENDING_MACHINE) {
				inputVendingMachineHavingMoney();
			}

		}

	}

	private void inputVendingMachineHavingMoney() {
		try {
			System.out.println(PROMPT_VENDING_MACHINE_HAVE_MONEY);
			int vendingMachineMoney = inputVendingMachineMoney();
			checkIfNegative(vendingMachineMoney);
		} catch (IllegalArgumentException exception) {
			printIllegalArgumentErrorMessage();
		}
	}

	private int inputVendingMachineMoney() {
		String vendingMachineMoneyString = readLine();
		int vendingMachineMoney = Integer.parseInt(vendingMachineMoneyString);
		return vendingMachineMoney;
	}

	private void printIllegalArgumentErrorMessage() {
		System.out.print(ILLEGAL_USER_INPUT_EXCEPTION_MESSAGE);
	}

	private void checkIfNegative(int vendingMachineMoney) {
		if (vendingMachineMoney <= 0) {
			throw new NegativeUserInputException();
		}
	}
}
