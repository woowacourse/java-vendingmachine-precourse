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

	public Change calculateChange() {
		Money totalChange = change.getTotalChange();
		if (totalChange.isSmaller(this.inputMoney.getTotal())) {
			return change;
		}
		// 잔돈을 돌려줄때 보유한 최소 개수의 동전으로 돌려주는 기능 구현
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
		inputMoney.spend(beverage.getPrice());
		beverages.sell(beverage);
	}

	public boolean canSell() {
		return !inputMoney.isSmaller(beverages.getMinimumBeveragePrice()) && !beverages.isAllSoldOut();
	}
}
