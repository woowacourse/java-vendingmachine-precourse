package vendingmachine.model;

import java.util.List;
import java.util.Map;

import vendingmachine.Coin;

public class VendingMachine {
	private int ownMoney;
	private int inputMoney;
	private List<Product> productList;
	private Map<Coin, Integer> coinIntegerMap;

	public void initOwnMoney(int ownMoney) {
		this.ownMoney = ownMoney;
	}

	public void initInputMoney(int inputMoney) {
		this.inputMoney = inputMoney;
	}


}
