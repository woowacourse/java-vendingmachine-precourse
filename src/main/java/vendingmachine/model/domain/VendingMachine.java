package vendingmachine.model.domain;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
	private int inputMoney;
	private List<Product> productList;
	private final Map<Coin, Integer> coinMap = new LinkedHashMap<>();

	public int getInputMoney() {
		return this.inputMoney;
	}

	public Map<Coin, Integer> getCoinMap() {
		return this.coinMap;
	}

	public List<Product> getProductList() {
		return this.productList;
	}

	public void initInputMoney(int inputMoney) {
		this.inputMoney = inputMoney;
	}

	public void initProductList(List<Product> productList) {
		this.productList = productList;
	}

	public void calculateInputMoneyAfterPurchase(int productPrice) {
		this.inputMoney -= productPrice;
	}

	public void generateCoin(int ownMoney) {
		initCoinMap();
		List<Integer> coinAmountList = Coin.getOrderedCoinAmounts();

		while (ownMoney > 0) {
			int coinAmount = Randoms.pickNumberInList(coinAmountList);
			if (coinAmount <= ownMoney) {
				coinMap.put(Coin.parse(coinAmount), coinMap.get(Coin.parse(coinAmount)) + 1);
				ownMoney = ownMoney - coinAmount;
			}
		}
	}

	private void initCoinMap() {
		List<Integer> coinAmountList = Coin.getOrderedCoinAmounts();
		coinAmountList.forEach(coinAmount -> {
			coinMap.put(Coin.parse(coinAmount), 0);
		});
	}

	public boolean end() {
		return inputMoney >= 0 && !productList.isEmpty() && isInputMoneyCanBuyProduct();
	}

	private boolean isInputMoneyCanBuyProduct() {
		Product product = productList
			.stream()
			.min(Comparator.comparing(Product::getPrice))
			.orElse(new Product());

		return product.getPrice() <= inputMoney;
	}
}
