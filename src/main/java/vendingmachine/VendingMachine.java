package vendingmachine;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachine {
	private List<Coin> coins;

	public static int generateRandomCoin() {
		List<Integer> coins = new ArrayList<>();
		for (Coin coin : Coin.values()) {
			coins.add(coin.getValue());
		}
		return pickNumberInList(coins);
	}

	public static List<Coin> generateRemainCoins(int remains) {
		List<Coin> coinList = Arrays.asList(Coin.values());
		while (remains != 0) {
			int newCoin = generateRandomCoin();
			if (remains < newCoin) {
				continue;
			}
			remains -= newCoin;
			addCountInCoins(coinList, newCoin);
		} return coinList;
	}

	public static void addCountInCoins(List<Coin> coinList, int coinValue) {
		for (Coin coin : coinList) {
			if (coin.getValue() == coinValue) {
				coin.addCount();
			}
		}
	}
	public static void main(String[] args) {
	}
}
