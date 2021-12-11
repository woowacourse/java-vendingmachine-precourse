package vendingmachine;

import static vendingmachine.utils.Constant.*;
import static vendingmachine.utils.validator.HoldingAmountValidator.*;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

public class VendingMachineController {

	private final VendingMachine vendingMachine;

	public VendingMachineController(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void run() {
		chargeHoldingAmount();
		addItem();
		int amount = inputAmount();
	}

	private void chargeHoldingAmount() {
		int holdingAmount = inputHoldingAmount();
		vendingMachine.insertCoins(holdingAmount);
		Output.holdingAmount(vendingMachine.getCoins());
	}

	private int inputHoldingAmount() {
		while (true) {
			try {
				String amount = Input.holdingAmount();
				return validateAmount(amount, AMOUNT);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void addItem() {
		String itemList = Input.item();
		vendingMachine.insertItems(itemList);
	}

	private int inputAmount() {
		while (true) {
			try {
				String amount = Input.inputAmount();
				return validateAmount(amount, AMOUNT);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
