package vendingmachine;

import java.util.HashMap;

import vendingmachine.view.InputView;

public class VendingMachine {
	InputView inputView = new InputView();

	HashMap<Coin, Integer> coins = new HashMap<>();

	public VendingMachine() {
		System.out.println(getInputAmount());
	}

	private int getInputAmount() {
		String inputAmount;
		do {
			inputAmount = inputView.getInputAmount();
		} while (!InputAmountValidator.isValidated(inputAmount));
		return Integer.parseInt(inputAmount);
	}

	private void setCoins(String inputAmount) {

	}

}
