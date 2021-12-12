package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	public boolean isDivided(int money) {
		return money % amount == 0;
	}

	@Override
	public String toString() {
		return amount + "원";
	}

	public int randomPick(int money) {
		if (isTenCoin()) {
			return money / COIN_10.amount;
		}
		List<Integer> pickList = fillPickList(money);
		return Randoms.pickNumberInList(pickList);
	}

	public int getRemainMoney(int money, int coinNum) {
		return money - (coinNum * amount);
	}

	private boolean isTenCoin() {
		return amount == COIN_10.amount;
	}

	private List<Integer> fillPickList(int money) {
		List<Integer> pickList = new ArrayList<>();
		for (int i = 0; i <= money / amount; i++) {
			pickList.add(i);
		}
		return pickList;
	}
}
