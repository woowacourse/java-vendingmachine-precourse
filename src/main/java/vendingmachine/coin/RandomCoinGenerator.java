package vendingmachine.coin;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Money;
import vendingmachine.Notification;
import vendingmachine.exception.VendingMachineException;

public class RandomCoinGenerator implements CoinGenerator {
	@Override
	public Coins generate(Money money) {
		Map<Coin, Integer> coins = initializeCoins();
		while(!money.isZero()) {
			Coin coin = generateCoin(money);
			coins.computeIfPresent(coin, (key, value) -> value+1);
			money.spend(coin.getMoney());
		}
		return new Coins(coins);
	}

	private Map<Coin, Integer> initializeCoins() {
		Map<Coin, Integer> coins = new EnumMap<>(Coin.class);
		for (Coin coin : Coin.getCoins()) {
			coins.put(coin,0);
		}
		return coins;
	}

	private Coin generateCoin(final Money money) {
		List<Integer> possibleCoinAmounts = Coin.getPossibleCoinAmounts(money);
		int randomNumber = Randoms.pickNumberInList(possibleCoinAmounts);
		Money randomMoney = Money.of(randomNumber);
		return Coin.valueOf(randomMoney)
			.orElseThrow(() -> new VendingMachineException(Notification.COIN_NOT_FOUND.getMessage()));
	}
}
