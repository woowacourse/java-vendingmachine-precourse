package vendingmachine.coin;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoinService {

	public Coin findCoinByPrice(int money) {
		int price = pickRandomPrice(money);
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.isSameAmount(price))
			.collect(Collectors.toList())
			.get(0);
	}

	private int pickRandomPrice(int money) {
		return pickNumberInList(getPossibleAmountList(money));
	}

	private List<Integer> getPossibleAmountList(int money) {
		return Arrays.stream(Coin.values())
			.filter(coin -> coin.lessThanEqual(money))
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	}

}
