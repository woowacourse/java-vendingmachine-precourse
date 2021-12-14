package vendingmachine.service;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import vendingmachine.domain.Coin;

class ChangeServiceTest {
	@Test
	void changeTest() {
		ChangeService changeService = new ChangeService();

		// given
		Map<Coin, Integer> coins = new EnumMap<>(Coin.class);
		coins.put(Coin.COIN_500, 1);
		coins.put(Coin.COIN_100, 3);
		coins.put(Coin.COIN_50, 4);
		coins.put(Coin.COIN_10, 2);

		int remainedMoney = 450;

		// when
		Map<Coin, Integer> change = changeService.returnChange(coins, remainedMoney);

		// then
		for (Map.Entry<Coin, Integer> en : change.entrySet()) {
			System.out.println("Key : Value == " + en.getKey() + " : " + en.getValue());
			assertThat(en.getValue()).isEqualTo(3);
		}
	}
}
