package vendingmachine.coin;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Money;

public class RandomCoinGenerator implements CoinGenerator {

	@Override
	public Map<Coin, Integer> generate(Money money) {
		Map<Coin, Integer> coins = new EnumMap<>(Coin.class);
		while(!money.isZero()) {
			Coin coin = generateCoin(money);
			coins.merge(coin, 0, (k,v) -> v++);
			money.spend(coin.getMoney());
		}
		return coins;
	}

	private Coin generateCoin(final Money money) {
		List<Integer> possibleCoinAmounts = Coin.getPossibleCoinAmounts(money);
		int randomNumber = Randoms.pickNumberInList(possibleCoinAmounts);
		Money randomMoney = Money.of(randomNumber);
		return Coin.valueOf(randomMoney);
	}

}
