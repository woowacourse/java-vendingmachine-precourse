package vendingmachine.domain;

import java.util.Map;

import vendingmachine.exception.NotFoundBeverageException;

public class VendingMachine {
	private final Beverages beverages;
	private final Change change;
	private final Money inputMoney;

	public VendingMachine(Beverages beverages, Change change, Money money) {
		this.beverages = beverages;
		this.change = change;
		this.inputMoney = money;
	}

	public Change calculate() {
		Money totalChange = change.totalChange();
		if (totalChange.isSmaller(this.inputMoney.getTotal())) {
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
		return inputMoney;
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
		inputMoney.spend(beverage.getPrice());
		beverages.put(beverage, beverages.get(beverage) - 1);
	}

	public boolean canSell() {
		return !inputMoney.isSmaller(beverages.getMinimumBeveragePrice()) && !beverages.isAllSoldOut();
	}
}
