package vendingmachine;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.Coin.*;

import org.junit.jupiter.api.Test;

public class CoinBucketTest {

	@Test
	void 코인_랜덤생성_테스트() {
		CoinGenerator coinGenerator = (money) -> {
			money.use(COIN_10.getAmount());
			return COIN_10;
		};
		CoinBucket.of(Money.from(50), coinGenerator);

		assertEquals(5, COIN_10.getCount());
	}
}
