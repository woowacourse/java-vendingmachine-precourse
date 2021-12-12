package vendingmachine.coin;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Money;
import vendingmachine.Notification;
import vendingmachine.exception.DomainNotFoundException;
import vendingmachine.quantity.Quantity;

public class RandomCoinGenerator implements CoinGenerator {
	@Override
	public Coins generate(Money money) {
		Map<Coin, Quantity> coins = initializeCoins();
		while(!money.isZero()) {
			Coin coin = generateCoin(money);
			coins.computeIfPresent(coin, (originCoin, quantity) -> quantity.up());
			money.spend(coin.getMoney());
		}
		return new Coins(coins);
	}

	private Map<Coin, Quantity> initializeCoins() {
		Map<Coin, Quantity> coins = new EnumMap<>(Coin.class);
		for (Coin coin : Coin.getSortedCoins()) {
			coins.put(coin,Quantity.from());
		}
		return coins;
	}

	private Coin generateCoin(final Money money) {
		List<Integer> possibleCoinAmounts = Coin.getPossibleCoinAmounts(money);
		int randomNumber = Randoms.pickNumberInList(possibleCoinAmounts);
		Money randomMoney = Money.of(randomNumber);
		return Coin.valueOf(randomMoney)
			.orElseThrow(() -> new DomainNotFoundException(Notification.COIN_NOT_FOUND.getMessage()));
	}
}
