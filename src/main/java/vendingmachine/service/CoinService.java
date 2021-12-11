package vendingmachine.service;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class CoinService {

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

	private int getPickedCoin(List<Coin> coins, int savedMoney) {
		return Randoms.pickNumberInList(coins.stream()
			.map(Coin::getAmount)
			.filter(amount -> amount <= savedMoney)
			.collect(Collectors.toList()));
	}

}
