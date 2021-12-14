package vendingmachine.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.models.Coin;

@DisplayName("CoinTypeGenerator 클래스")
class CoinTypeGeneratorTest {

	@DisplayName("코인 종료가 제대로 나오는지 확인")
	@Test
	void generateCoinTypes() {
		List<Integer> coinTypes = CoinTypeGenerator.getCoinTypes();
		coinTypes.forEach(coinType -> {
			assertTrue(coinType == Coin.COIN_500.getAmount()
				|| coinType == Coin.COIN_100.getAmount()
				|| coinType == Coin.COIN_50.getAmount()
				|| coinType == Coin.COIN_10.getAmount());
		});
	}
}
