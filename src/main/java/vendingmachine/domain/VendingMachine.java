package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {
	static final String MSG_SMALL_INPUT_MONEY_ERROR = "[ERROR] 투입 금액이 물건 가격보다 적다.";
	static final String MSG_OUT_OF_STOCK_ERROR = "[ERROR] 해당 상품은 품절되었다.";

	private final Coins coins;
	private final Products products;
	private int inputMoney;

	public VendingMachine(Coins coins, Products products, int inputMoney) {
		this.coins = coins;
		this.products = products;
		this.inputMoney = inputMoney;
	}

	public int getInputMoney() {
		return inputMoney;
	}

	public boolean checkTermination() {
		return products.isLessThanMinPrice(inputMoney)
			|| products.getTotalAmount() == 0;
	}

	public void buy(String buyingProductName) {
		validateBuyingProductName(buyingProductName);
		Product product = products.getProductByName(buyingProductName);
		product.decreaseAmount();
		inputMoney = product.payMoney(inputMoney);
	}

	private void validateBuyingProductName(String buyingProductName) {
		Product product = products.getProductByName(buyingProductName);
		isSmallInputMoney(product);
		isOutOfStock(product);
	}

	private void isSmallInputMoney(Product product) {
		if (product.getSmallerPrice(inputMoney) > inputMoney) {
			throw new IllegalArgumentException(MSG_SMALL_INPUT_MONEY_ERROR);
		}
	}

	private void isOutOfStock(Product product) {
		if (!product.isInStock()) {
			throw new IllegalArgumentException(MSG_OUT_OF_STOCK_ERROR);
		}
	}

	public Map<Coin, Integer> giveChange() {
		if (coins.isGreaterThanTotalMoney(inputMoney)) {
			return coins.getCoinsMap();
		}
		return coins.calculateChange(inputMoney);
	}
}
