package vendingmachine.randoms;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.RepeatedTest;

import vendingmachine.model.Coin;
import vendingmachine.service.CoinService;

public class RandomCoinTest {

	@RepeatedTest(20)
	void coinAmountTest() {
		//given
		CoinService coinController = new CoinService();

		//when
		Map<Coin, Integer> coinIntegerMap = coinController.getCoinsByBalance(1200);

		//then
		assertThat(coinIntegerMap.get(Coin.COIN_10) * 10 +
			coinIntegerMap.get(Coin.COIN_50) * 50 +
			coinIntegerMap.get(Coin.COIN_100) * 100 +
			coinIntegerMap.get(Coin.COIN_500) * 500
		).isEqualTo(1200);
	}
}
