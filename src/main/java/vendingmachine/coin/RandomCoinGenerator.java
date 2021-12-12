package vendingmachine.coin;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Money;
import vendingmachine.Notification;
import vendingmachine.exception.DomainNotFoundException;

public class RandomCoinGenerator implements CoinGenerator {
	@Override
	public Coins generate(Money money) {
		Coins coins = new Coins();
		while (!money.isZero()) {
			Coin coin = generateCoin(money);
			coins.add(coin);
			money.spend(coin.getMoney());
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
