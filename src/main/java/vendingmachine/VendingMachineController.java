package vendingmachine;

import static vendingmachine.utils.Constant.*;
import static vendingmachine.utils.validator.AmountValidator.*;

import vendingmachine.domain.Coins;
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
		purchaseItems(amount);
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

	private void purchaseItems(int amount) {
		while (vendingMachine.availablePurchase(amount)) {
			Output.inputAmount(amount);
			String itemName = inputItemName();
			amount -= vendingMachine.purchaseItem(itemName);
		}

		returnChange(amount);
	}

	private String inputItemName() {
		while (true) {
			try {
				String itemName = Input.itemName();
				vendingMachine.checkItem(itemName);
				return itemName;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void returnChange(int amount) {
		Output.inputAmount(amount);
		Coins change = vendingMachine.returnCoins(amount);
		Output.change(change);
	}
}
