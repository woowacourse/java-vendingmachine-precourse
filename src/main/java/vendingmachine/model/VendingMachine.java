package vendingmachine.model;

import java.util.List;
import vendingmachine.utils.CoinCaseFactory;
import vendingmachine.utils.ExceptionUtils;

public class VendingMachine {

	private final List<CoinCase> coinsCase;

	public VendingMachine(int amount) {
		ExceptionUtils.validateMoney(amount);
		this.coinsCase = CoinCaseFactory.makeCoinsCase(amount);
	}

	public List<CoinCase> getCoinsCase() {
		return coinsCase;
	}
}
