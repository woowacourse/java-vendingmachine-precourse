package vendingmachine.randoms;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import vendingmachine.Coin;
import vendingmachine.controller.CoinController;

public class RandomCoinTest {

	@RepeatedTest(20)
	@Test
	void coinAmountTest() {
		//given
		CoinController coinController = new CoinController();

		//when
		Map<Coin, Integer> coinIntegerMap = coinController.setCoinsByBalance(1000);

		//then
		assertThat(coinIntegerMap.get(Coin.COIN_10) * 10 +
			coinIntegerMap.get(Coin.COIN_50) * 50 +
			coinIntegerMap.get(Coin.COIN_100) * 100 +
			coinIntegerMap.get(Coin.COIN_500) * 500
		).isEqualTo(1000);
	}
}
