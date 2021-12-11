package vendingmachine.model;

import static vendingmachine.constant.Constant.*;

public class PossessionMoney {

	private int money = 0;

	public PossessionMoney(int money) {
		this.money = money;
	}

	public boolean isBiggerThanMinimumCoin() {
		return money >= MINIMUM_COIN_AMOUNT;
	}

	public boolean canMoneyIntoCoin(int randomCoin) {
		return money >= randomCoin;
	}

	public void changeMoneyIntoCoin(int randomMoney) {
		money -= randomMoney;
	}
}
