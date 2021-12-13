package vendingmachine.view.classes;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.constant.ExceptionConstant.*;
import static vendingmachine.constant.PromptConstant.*;

import vendingmachine.constant.VendingMachineStatus;
import vendingmachine.controller.CoinGeneratorInterface;
import vendingmachine.controller.classes.CoinGenerator;
import vendingmachine.exception.InvalidUserInputException;
import vendingmachine.exception.NegativeUserInputException;
import vendingmachine.model.Coin;
import vendingmachine.view.VendingMachine;

public class VendingMachineUI implements VendingMachine {
	VendingMachineStatus vendingMachineStatus = VendingMachineStatus.INPUT_MONEY_IN_VENDING_MACHINE;
	private int moneyInVendingMachine = 0;

	@Override
	public void start() {
		while (true) {
			if (vendingMachineStatus == VendingMachineStatus.INPUT_MONEY_IN_VENDING_MACHINE) {
				proceedInputVendingMachineHavingMoney();
			}
			if (vendingMachineStatus == VendingMachineStatus.SHOW_COINS_IN_VENDING_MACHINE) {
				System.out.println(PROMPT_VENDING_MACHINE_HAVE_COINS);
				CoinGeneratorInterface coinGeneratorInterface = new CoinGenerator();
				System.out.println(coinGeneratorInterface.getRandomCoins(moneyInVendingMachine).toString());
				break;
			}
			if (vendingMachineStatus == VendingMachineStatus.INPUT_GOODS_AND_PRICES_IN_VENDING_MACHINE) {

			}
			if (vendingMachineStatus == VendingMachineStatus.INPUT_USER_MONEY) {

			}
			if (vendingMachineStatus == VendingMachineStatus.SHOW_USER_LEFT_MONEY) {

			}
			if (vendingMachineStatus == VendingMachineStatus.INPUT_USER_GOODS) {

			}
			if (vendingMachineStatus == VendingMachineStatus.SHOW_LEFT_COIN) {
				break;
			}

		}

	}

	private void proceedInputVendingMachineHavingMoney() {
		inputVendingMachineHavingMoney();
	}

	private void inputVendingMachineHavingMoney() {
		System.out.println(PROMPT_VENDING_MACHINE_HAVE_MONEY);
		if(inputVendingMachineMoney()) {
			checkIfNegative(moneyInVendingMachine);
		}
	}

	private boolean inputVendingMachineMoney() {
		String vendingMachineMoneyString = readLine();
		try {
			isNumber(vendingMachineMoneyString);
		} catch (InvalidUserInputException exception) {
			return false;
		}
		moneyInVendingMachine = Integer.parseInt(vendingMachineMoneyString);
		return true;
	}

	private void isNumber(String vendingMachineMoneyString) {
		if (!vendingMachineMoneyString.matches(NUMBER_REGEX)) {
			throw new InvalidUserInputException();
		}
	}

	private void printIllegalArgumentErrorMessage() {
		System.out.print(ILLEGAL_USER_INPUT_EXCEPTION_MESSAGE);
	}

	private void checkIfNegative(int vendingMachineMoney) {
		try {
			isNotNegative(vendingMachineMoney);
			vendingMachineStatus = VendingMachineStatus.SHOW_COINS_IN_VENDING_MACHINE;
		} catch (NegativeUserInputException exception) {

		}
	}

	private void isNotNegative(int vendingMachineMoney) {
		if (vendingMachineMoney <= 0) {
			throw new NegativeUserInputException();
		}
	}
}
