package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
	private static final String ERROR_HEADER = "[ERROR] ";
	private static final String NOT_EXIST_PRODUCT = "구매할 수 있는 상품이 존재하지 않습니다. 자판기에서 구매할 수 있고 존재하는 상품을 입력해주세요. ";

	private final Coins vendingMachineChange;
	private final List<Goods> goods;
	private int inputMoney;

	public VendingMachine(Coins vendingMachineChange, List<Goods> goods, int inputMoney) {
		this.vendingMachineChange = vendingMachineChange;
		this.goods = goods;
		this.inputMoney = inputMoney;
	}

	public void buyProduct(String inputProductName) {
		Goods goods = findProudctInVendingMachine(inputProductName);
		inputMoney -= goods.getPrice();
		goods.buyOneProduct();
	}

	public Coins getLeftoverCash() {
		if (inputMoney >= vendingMachineChange.getCoinSum()) {
			return vendingMachineChange;
		}
		return calculateLeftoverCash(inputMoney);
	}

	public int getInputMoney() {
		return inputMoney;
	}

	public int getProductsCount() {
		int counts = 0;
		for (Goods goods : this.goods) {
			counts += goods.getCount();
		}
		return counts;
	}

	public int getMinPriceOfProducts() {
		int minValue = Integer.MAX_VALUE;
		for (Goods goods : this.goods) {
			if (goods.getPrice() < minValue && goods.getCount() > 0) {
				minValue = goods.getPrice();
			}
		}
		return minValue;
	}

	private Goods findProudctInVendingMachine(String productName) {
		for (Goods goods : this.goods) {
			if (goods.getName().equals(productName) && inputMoney >= goods.getPrice() && goods.getCount() > 0) {
				return goods;
			}
		}
		throw new IllegalArgumentException(ERROR_HEADER + NOT_EXIST_PRODUCT);
	}

	private Coins calculateLeftoverCash(int toReturnCash) {
		int minCoinCount;
		Coins leftoverCoinCountMap = new Coins();
		for (Coin coin : Coin.values()) {
			if (!checkValidMoney(toReturnCash)) {
				return leftoverCoinCountMap;
			}
			minCoinCount = findMinCoinCount(coin, toReturnCash);
			toReturnCash -= minCoinCount * coin.getAmount();
			leftoverCoinCountMap.getCoinCount().replace(coin, leftoverCoinCountMap.getCoinCount().get(coin) + minCoinCount);
			this.vendingMachineChange.getCoinCount().replace(coin, this.vendingMachineChange.getCoinCount().get(coin) - minCoinCount);
		}
		return leftoverCoinCountMap;
	}

	private boolean checkValidMoney(int toReturnCash) {
		if (toReturnCash != 0) {
			return true;
		}
		return false;
	}

	private int findMinCoinCount(Coin coin, int toReturnCash) {
		int coinValue = coin.getAmount();
		return Math.min(toReturnCash / coinValue, this.vendingMachineChange.getCoinCount().get(coin));
	}
}
