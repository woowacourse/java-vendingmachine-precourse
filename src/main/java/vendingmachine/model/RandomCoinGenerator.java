package vendingmachine.model;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCoinGenerator implements CoinGenerator {
	private static final List<Integer> coinAmounts = cacheCoinAmounts();

	private static List<Integer> cacheCoinAmounts() {
		return Arrays.stream(Coin.values())
			.map(Coin::getAmount)
			.map(Money::getAmount)
			.collect(toList());
	}

	@Override
	public Coin generateCoinWithMoney(Money assets) {
		Money amount = Money.from(Randoms.pickNumberInList(coinAmounts));
		if (assets.isValuableThan(amount)) {
			assets.use(amount);
			return Coin.from(amount);
		}
		return generateCoinWithMoney(assets);
	}
}
