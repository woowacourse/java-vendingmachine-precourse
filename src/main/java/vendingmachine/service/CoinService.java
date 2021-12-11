package vendingmachine.service;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class CoinService {

	private static final int TOTAL_NUM_COIN = 4;
	private static final int MINIMUM_COIN_AMOUNT = 10;

	public void init(List<Coin> coins) {
		coins.add(Coin.COIN_500);
		coins.add(Coin.COIN_100);
		coins.add(Coin.COIN_50);
		coins.add(Coin.COIN_10);
	}

	public void pickRandomCoins(List<Coin> coins, int savedMoney) {
		while (savedMoney > 0) {
			int pickedCoinAmount = getPickedCoin(coins, savedMoney);
			Coin pickedCoin = coins.stream()
				.filter(coin -> coin.getAmount() == pickedCoinAmount)
				.findAny()
				.orElse(null);
			pickedCoin.addCoin();
			savedMoney -= pickedCoin.getAmount();
		}
	}

	public void getRemainingCoins(List<Coin> coins, int remainingMoney) {
		int coinIndex = 0;
		while (remainingMoney >= MINIMUM_COIN_AMOUNT && coinIndex < TOTAL_NUM_COIN) {
			Coin coin = coins.get(coinIndex);
			if (coin.getAmount() > remainingMoney) {
				coinIndex += 1;
				continue;
			}
			if (coin.getNumberOfCoin() < 1) {
				coinIndex += 1;
				continue;
			}
			coin.addRemainingNumber();
			coin.reduceCoin();
			remainingMoney -= coin.getAmount();
		}
	}

	private int getPickedCoin(List<Coin> coins, int savedMoney) {
		return Randoms.pickNumberInList(coins.stream()
			.map(Coin::getAmount)
			.filter(amount -> amount <= savedMoney)
			.collect(Collectors.toList()));
	}

}
