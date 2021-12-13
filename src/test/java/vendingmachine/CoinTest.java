package vendingmachine;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.Coin.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class CoinTest {

	@AfterEach
	void reset() {
		Coin.resetForTest();
	}

	@Test
	void 동전생성_테스트() {
		assertEquals(COIN_10, Coin.from(Money.from(10)));
		assertEquals(Coin.COIN_50, Coin.from(Money.from(50)));
		assertEquals(Coin.COIN_100, Coin.from(Money.from(100)));
		assertEquals(Coin.COIN_500, Coin.from(Money.from(500)));
	}

	@Test
	void 동전생성_알맞지않은가격_에러() {
		assertThatThrownBy(() -> Coin.from(Money.from(70)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 동전_개수_증가_테스트() {
		COIN_10.addOne();
		assertEquals(1, COIN_10.getCount());
	}
}
