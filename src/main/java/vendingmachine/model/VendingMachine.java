package vendingmachine.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.util.Utils;

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

	public void generateCoin() {
		List<Integer> coinAmountList = Coin.getOrderedCoinAmounts();
		coinAmountList.forEach(amount -> {
			int maxRange = Utils.getMaxRange(ownMoney, amount);
			int randomNumber = Randoms.pickNumberInRange(0, maxRange);
			coinIntegerMap.put(Coin.parse(amount), randomNumber);
			ownMoney = ownMoney - randomNumber*amount;
		});
	}
}
