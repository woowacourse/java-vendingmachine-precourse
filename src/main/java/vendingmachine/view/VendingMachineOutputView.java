package vendingmachine.view;

import static vendingmachine.constants.HostMessages.*;
import static vendingmachine.constants.ProgramConstants.*;

import java.util.List;
import java.util.Map;

import vendingmachine.resource.Coin;

public class VendingMachineOutputView {
	private static final VendingMachineOutputView vendingMachineOutputView = new VendingMachineOutputView();

	private VendingMachineOutputView() {
	}

	public static VendingMachineOutputView getVendingMachineOutputView() {
		return vendingMachineOutputView;
	}

	public void printAmountInputMessage() {
		System.out.println(VENDING_MACHINE_INITIAL_MONEY_INPUT_MESSAGE);
	}

	public void printVendingMachineInitialCoinsOutputMessage() {
		System.out.println(VENDING_MACHINE_INITIAL_COINS_OUTPUT_MESSAGE);
	}

	public void printInitialItemsInputMessage() {
		System.out.println(INITIAL_ITEMS_INPUT_MESSAGE);
	}

	public void printVendingMachineCoins(Map<Integer, Integer> numberOfCoins) {
		for (int monetaryUnit : numberOfCoins.keySet()) {
			System.out.println(monetaryUnit+"원 - " + numberOfCoins.get(monetaryUnit)+"개");
		}
		System.out.println();
	}

	public void printUserInputAmountInputMessage() {
		System.out.println(USER_INPUT_AMOUNT_INPUT_MESSAGE);
	}

	public void printRemainingAmount(int remainingAmount) {
		System.out.println(REMAINING_AMOUNT_OUTPUT_START_MESSAGE + remainingAmount + CURRENCY);
	}

	public void printPurchasingInputMessage() {
		System.out.println(PURCHASING_INPUT_MESSAGE);
	}

	public void printChangeOutputMessage() {
		System.out.println(CHANGE_OUTPUT_MESSAGE);
	}
}
