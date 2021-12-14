package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinTest {
	@DisplayName("금액으로 Coin 객체 획득")
	@Test
	public void getCoinAmount() throws Exception {
		//given
		Coin coin500 = Coin.getCoinByAmount(500);
		Coin coin100 = Coin.getCoinByAmount(100);
		Coin coin50 = Coin.getCoinByAmount(50);
		Coin coin10 = Coin.getCoinByAmount(10);
		//then
		assertEquals(coin500, Coin.COIN_500);
		assertEquals(coin100, Coin.COIN_100);
		assertEquals(coin50, Coin.COIN_50);
		assertEquals(coin10, Coin.COIN_10);
	}

	@DisplayName("얼마짜리 동전이 존재하는지 리스트 획득")
	@Test
	public void getCoinAmountList() throws Exception {
		//given
		List<Integer> coinAmountList = Coin.getCoinAmountList();
		List<Integer> testAmountList = Arrays.asList(500, 100, 50, 10);
		int idx = 0;
		//then
		for (Integer amount : coinAmountList) {
			assertEquals(testAmountList.get(idx++), amount);
		}
	}

	@DisplayName("나누어떨어지는지 확인")
	@Test
	public void isDivided() throws Exception {
		//given
		int trueTest1 = 500;
		int trueTest2 = 300;
		int trueTest3 = 30;

		int falseTest1 = 5;
		int falseTest2 = 300;
		int falseTest3 = 70;
		//then
		assertTrue(Coin.COIN_500.isDivided(trueTest1));
		assertTrue(Coin.COIN_100.isDivided(trueTest2));
		assertTrue(Coin.COIN_10.isDivided(trueTest3));

		assertFalse(Coin.COIN_10.isDivided(falseTest1));
		assertFalse(Coin.COIN_500.isDivided(falseTest2));
		assertFalse(Coin.COIN_100.isDivided(falseTest3));
	}
}
