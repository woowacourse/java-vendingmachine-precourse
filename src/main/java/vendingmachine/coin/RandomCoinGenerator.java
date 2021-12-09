package vendingmachine.coin;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Money;

public class RandomCoinGenerator implements CoinGenerator {
	@Override
	public Coins generate(Money money) {
		Map<Coin, Integer> coins = new EnumMap<>(Coin.class);
		while(!money.isZero()) {
			Coin coin = generateCoin(money);
			coins.merge(coin, 1, (originCount,newCount) -> originCount+1);
			money.spend(coin.getMoney());
		}
		return new Coins(coins);
	}

	private Coin generateCoin(final Money money) {
		List<Integer> possibleCoinAmounts = Coin.getPossibleCoinAmounts(money);
		int randomNumber = Randoms.pickNumberInList(possibleCoinAmounts);
		Money randomMoney = Money.of(randomNumber);
		return Coin.valueOf(randomMoney);
	}
}
