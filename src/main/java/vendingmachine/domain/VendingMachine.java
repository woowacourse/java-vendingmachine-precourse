package vendingmachine.domain;

import java.util.Map;

import vendingmachine.exception.NotFoundBeverageException;

public class VendingMachine {
	private final Beverages beverages;
	private final Change change;
	private final Money money;

	public VendingMachine(Beverages beverages, Change change, Money money) {
		this.beverages = beverages;
		this.change = change;
		this.money = money;
	}

	public Change calculate(Money inputMoney) {
		if (money.isSmaller(inputMoney.getTotal())) {
			return change;
		}
		return change;
	}

	public Beverages getBeverages() {
		return beverages;
	}

	public Change getChange() {
		return change;
	}

	public Money getMoney() {
		return money;
	}

	public Beverage findBeverageByName(String name) {
		for (Beverage beverage : beverages.getBeverages().keySet()) {
			if (beverage.isSameName(name)) {
				return beverage;
			}
		}
		throw new NotFoundBeverageException();
	}

	public void sell(Beverage beverage) {
		Map<Beverage, Integer> beverages = this.beverages.getBeverages();
		money.spend(beverage.getPrice());
		beverages.put(beverage, beverages.get(beverage) - 1);
	}

	public boolean canSell() {
		return !money.isSmaller(beverages.getMinimumBeveragePrice()) && !beverages.isAllSoldOut();
	}
}
