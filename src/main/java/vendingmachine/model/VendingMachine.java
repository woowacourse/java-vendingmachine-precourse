package vendingmachine.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.util.Utils;

public class VendingMachine {
	private int ownMoney; // 갖고 있을 필요가 있나?
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

	public void generateProduct(String products) {
		this.productList = Arrays.stream(products.split(";"))
			.map(Product::createProduct)
			.collect(Collectors.toList());
	}
}
