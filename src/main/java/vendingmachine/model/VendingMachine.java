package vendingmachine.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.util.Constant;
import vendingmachine.validator.Validator;

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

	public void initInputMoney(int inputMoney) {
		this.inputMoney = inputMoney;
	}

	public void generateCoin(int ownMoney) {
		initCoinMap();
		List<Integer> coinAmountList = Coin.getOrderedCoinAmounts();

		while (ownMoney > 0) {
			int coinAmount = Randoms.pickNumberInList(coinAmountList);
			if (coinAmount <= ownMoney) {
				coinMap.put(Coin.parse(coinAmount), coinMap.get(Coin.parse(coinAmount))+1);
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

	public void generateProduct(String products) throws IllegalArgumentException {
		this.productList = Arrays.stream(products.split(Constant.PRODUCT_SEPARATOR))
			.map(Product::createProduct)
			.collect(Collectors.toList());

		List<String> distinctProductList = productList
			.stream()
			.map(Product::getName)
			.distinct()
			.collect(Collectors.toList());

		Validator.validateProductList(distinctProductList, productList);
	}

	public void removeProduct() {
		List<Product> productListToDelete = this.productList
			.stream()
			.filter(it -> it.getAmount() == 0)
			.collect(Collectors.toList());

		productListToDelete.forEach(productList::remove);
	}

	public void purchase(String productName) {
		Product product = productList.stream()
			.filter(it -> it.getName().equals(productName))
			.findFirst()
			.map(Product::purchaseProduct)
			.orElseThrow(() -> new IllegalArgumentException(Validator.ERROR_NOT_EXISTED_PRODUCT));

		removeProduct();
		inputMoney -= product.getPrice();
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
