package vendingmachine.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

import static vendingmachine.view.Print.*;

import java.util.HashMap;
import java.util.List;

public class VendingMachine {
	private HashMap<Coin, Integer> changes = new HashMap<>(Coin.values().length);
	private HashMap<Product, Integer> products = new HashMap<>();
	private int money;

	private static final int INITIAL_COIN = 0;
	private static final int ADD_COUNT_OF_COIN = 1;

	public VendingMachine() {
		Coin[] coins = Coin.values();

		for (Coin coin : coins) {
			this.changes.put(coin, INITIAL_COIN);
		}
	}

	public void setChanges(int money) {
		List<Integer> amountOfCoins = Coin.getAmountOfCoins();

		while (money > 0) {
			int amount = pickNumberInList(amountOfCoins);

			if (money < amount) {
				continue;
			}
			Coin coin = Coin.getCoinAsAmount(amount);
			addCountOfCoin(coin);
			money -= amount;
		}
	}

	private void addCountOfCoin(Coin coin) {
		this.changes.put(coin, this.changes.get(coin) + ADD_COUNT_OF_COIN);
	}

	public void noticeCountOfCoins() {
		Coin[] coins = Coin.values();

		for (Coin coin : coins) {
			int amount = Coin.getAmountOfCoin(coin);
			int count = changes.get(coin);

			printCountOfCoins(amount, count);
		}
	}

	// 상품 정보 저장
	
	// 투입 금액 정보 저장

	// 구매한 상품 정보 개수 및 투입 금액 차감

	// 잔돈 정보 반환
}
