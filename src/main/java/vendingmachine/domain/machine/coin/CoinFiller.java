package vendingmachine.domain.machine.coin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class CoinFiller {

	public List<Coin> convertMoneyToCoins(int money) {
		List<Coin> coins = new ArrayList<>();
		while (isMoneyExist(money)) {
			Coin coin = pickCoin(money);
			coins.add(coin);
			money -= coin.getAmount();
		}
		return coins;
	}

	private boolean isMoneyExist(int money) {
		return (money > 0);
	}

	private Coin pickCoin(int money) {
		List<Coin> coinsForPick = Coin.getCoinsLessThen(money);
		return pickCoinInList(coinsForPick);
	}

	private Coin pickCoinInList(List<Coin> coinsForPick) {
		List<Integer> numbers = coinsForPick.stream().map(Coin::getAmount).collect(Collectors.toList());
		int number = Randoms.pickNumberInList(numbers);
		return Coin.of(number);
	}

}
