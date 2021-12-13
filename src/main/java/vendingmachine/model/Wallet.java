package vendingmachine.model;

import java.util.LinkedHashMap;
import java.util.Map;

import vendingmachine.validation.WalletValidation;
import vendingmachine.view.ErrorView;
import vendingmachine.view.InputView;

public class Wallet {

	private Map<Coin, Integer> wallet = new LinkedHashMap<>();

	public Wallet() {
		setWallet();
	}

	private void setWallet() {
		try {
			String input = InputView.setVendingMachineWallet();
			WalletValidation.setWalletValidation(input);
			makeRandomCoin(Integer.parseInt(input));
		} catch (IllegalArgumentException illegalArgumentException) {
			ErrorView.illegalArgumentException(illegalArgumentException.getMessage());
			setWallet();
		}
	}

	private void makeRandomCoin(int money) {
		Coin[] coins = Coin.values();


	}
}
