package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinTest {

	@Test
	@DisplayName("정수형으로 동전을 생성할 수 있다.")
	public void testCoinFromInt() {
	    // given
	    int amount = 500;
	    // when
		Coin coin = Coin.of(amount);
	    // then
		assertSame(Coin.COIN_500, coin);
	}

	@Test
	@DisplayName("동전에 맞지 않는 값이 들어올 경우 에러를 발생시킨다")
	public void testCoinFromWrongInt() {
	    // given
	    int amount = 11;
		// then
		assertThrows(NoSuchElementException.class, () -> Coin.of(amount));
	}

	@Test
	@DisplayName("동전의 값 중 하나를 랜덤으로 고른다")
	public void testPickRandom() {
	    // given
		int random = Coin.pickRandom();
		// when
	    Coin coin = Coin.of(random);
	    // then
		List<Coin> coins = Arrays.stream(Coin.values()).collect(Collectors.toList());
		assertTrue(coins.contains(coin));
	}
}