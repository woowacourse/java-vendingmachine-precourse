package vendingmachine.service;

import java.util.Map;
import java.util.TreeMap;

import vendingmachine.domain.Beverage;
import vendingmachine.domain.Beverages;
import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;
import vendingmachine.exception.NotFoundBeverageException;

public class VendingMachine {
	private static final int NONE = 0;
	private final Beverages beverages;
	private final Change change;
	private final Money inputMoney;

	public VendingMachine(Beverages beverages, Change change, Money money) {
		this.beverages = beverages;
		this.change = change;
		this.inputMoney = money;
	}

	public Change returnChange() {
		int money = inputMoney.getTotal();
		Map<Coin, Integer> changes = change.getChanges();
		Map<Coin, Integer> calculatedChange = new TreeMap<>();
		for (Coin coin : changes.keySet()) {
			money = makeChangeWithMoney(money, changes, calculatedChange, coin);
			if (money == NONE) {
				return new Change(calculatedChange);
			}
		}
		return new Change(calculatedChange);
	}

	private int makeChangeWithMoney(int money, Map<Coin, Integer> changes, Map<Coin, Integer> calculatedChange,
		Coin coin) {
		int count = money / coin.getAmount();
		if (count > changes.get(coin)) {
			count = changes.get(coin);
		}
		money -= count * coin.getAmount();
		calculatedChange.put(coin, count);
		return money;
	}

	public Money getMoney() {
		return inputMoney;
	}

	public Beverage findBeverageByName(String name) {
		return beverages.getBeverages()
			.keySet()
			.stream()
			.filter(beverage -> beverage.isSameName(name))
			.findAny()
			.orElseThrow(NotFoundBeverageException::new);
	}

	public void sell(Beverage beverage) {
		inputMoney.spend(beverage.getPrice());
		beverages.sell(beverage);
	}

	public boolean canNotSellOne(Beverage beverage) {
		return inputMoney.isSmaller(beverage.getPrice());
	}

	public boolean canSell() {
		return beverages.getBeverages()
			.entrySet()
			.stream()
			.anyMatch(beverages -> !inputMoney.isSmaller(beverages.getKey().getPrice()) && beverages.getValue() > NONE);
	}
}
