package vendingmachine.coin;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Amount;

public class RandomCoinGenerator implements CoinGenerator {

	@Override
	public Map<Coin, Integer> generate(Amount amount) {
		Map<Coin, Integer> coins = new EnumMap<>(Coin.class);
		while(!amount.isZero()) {
			Coin coin = generateCoin(amount);
			coins.merge(coin, 0, (k,v) -> v++);
			amount.spend(coin.getAmount());
		}
		return coins;
	}

	private Coin generateCoin(final Amount amount) {
		List<Integer> possibleAmounts = Coin.getPossibleAmounts(amount);
		int randomNumber = Randoms.pickNumberInList(possibleAmounts);
		Amount randomAmount = Amount.of(randomNumber);
		return Coin.valueOf(randomAmount);
	}

}
