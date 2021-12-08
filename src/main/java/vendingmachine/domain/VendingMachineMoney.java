package vendingmachine.domain;

import static constants.VendingMachineConstants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachineMoney {
	private int money;
	private final List<Coin> coins;

	public VendingMachineMoney(int money) {
		this.money = money;
		coins = Arrays.asList(Coin.COIN_500, Coin.COIN_100, Coin.COIN_50, Coin.COIN_10);
	}

	public void moneyToCoins() {
		List<Integer> tmpCoins = Arrays.asList(COIN_500_NUM, COIN_100_NUM, COIN_50_NUM, COIN_10_NUM);
		List<Integer> tmpCoinIdx = Arrays.asList(COIN_500_IDX, COIN_100_IDX, COIN_50_IDX,
			COIN_10_IDX);    // 500, 100, 50, 10의 인덱스값
		while (money != 0) {
			int idx = Randoms.pickNumberInList(tmpCoinIdx);
			int coin = tmpCoins.get(idx);
			if (money - coin >= 0) {
				money -= coin;
				coins.get(idx).increaseCount();
			}
		}
	}
}
