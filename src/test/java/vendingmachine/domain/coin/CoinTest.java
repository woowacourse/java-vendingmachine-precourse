package vendingmachine.domain.coin;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CoinTest {

	@Test
	void valueOfTest() {
		Arrays.stream(Coin.values())
			.forEach(coin -> {
				assertEquals(coin, Coin.valueOf(coin.getAmount()));
			});

		assertThrows(IllegalArgumentException.class, () -> {
			Coin.valueOf(111);
		});
	}

	@Test
	void getMinPriceCoin() {
		Coin minPriceCoin = Coin.getMinPriceCoin();
		Arrays.stream(Coin.values())
			.forEach(coin -> {
				assertTrue(minPriceCoin.getAmount() <= coin.getAmount());
			});
	}

}