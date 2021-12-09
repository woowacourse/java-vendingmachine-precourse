package vendingmachine.domain.coins;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coinamount.CoinAmount;

public class Coins {
	private final Map<Coin, CoinAmount> coins = new HashMap<>();

	private Coins() {
		// TODO: 생성자 구현 필요
	}

	public static Coins from(String vendingMachineBalance) {
		CoinsValidator.validateVendingMachineBalance(vendingMachineBalance);
		// TODO: 입력값에 따른 무작위 동전을 생성해야함
		return new Coins();
	}

	public CoinAmount getCoinAmount(Coin coin) {
		CoinAmount coinAmount = coins.get(coin);
		if (coinAmount != null) {
			return coinAmount;
		}

		return CoinAmount.from(0);
	}

	@Override
	public String toString() {
		return coins.toString();
	}
}
