package vendingmachine.model;

import java.util.Arrays;
import java.util.Comparator;
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
	private final Map<Coin, Integer> coinMap = new HashMap<>();

	public int getInputMoney() {
		return this.inputMoney;
	}

	public Map<Coin, Integer> getCoinMap() {
		return this.coinMap;
	}

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
			coinMap.put(Coin.parse(amount), randomNumber);
			ownMoney = ownMoney - randomNumber*amount;
			//TODO 마지막으로 남은 10원은 몽땅 생성할 수 있도록..!!
		});
	}

	public void generateProduct(String products) {
		this.productList = Arrays.stream(products.split(";"))
			.map(Product::createProduct)
			.collect(Collectors.toList());
	}

	public void purchase(String productName) {
		Product product = productList.stream()
			.filter(it -> it.getName().equals(productName))
			.findFirst()
			.map(Product::purchaseProduct) //TODO price 0 됐을 때 상품 리스트에서 제거하는거 하기
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 상품 이름입니다."));

		inputMoney -= product.getPrice();
	}

	public boolean end() {
		return inputMoney < 0 || productList.isEmpty() || isInputMoneyCanBuyProduct();
	}

	private boolean isInputMoneyCanBuyProduct() {
		Product product = productList
			.stream()
			.min(Comparator.comparing(Product::getPrice))
			.orElse(new Product());

		return product.getPrice() <= inputMoney;
	}
}
