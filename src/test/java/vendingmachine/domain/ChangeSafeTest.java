package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChangeSafeTest {

	@Test
	@DisplayName("잔돈금고를 생성한다.")
	public void testCreateChangeSafe() {
	    // given
		Map<Coin, Quantity> coinMap = new HashMap<>();
		coinMap.put(Coin.COIN_50, new Quantity(5));
	    // when
		ChangeSafe changeSafe = new ChangeSafe(coinMap);
	    // then
		System.out.println("changeSafe = " + changeSafe);
		assertEquals("500원 - 0개\n"
			+ "100원 - 0개\n"
			+ "50원 - 5개\n"
			+ "10원 - 0개", changeSafe.toString());
	}

	@Test
	@DisplayName("잔돈금고는 비어있는 상태로 초기화할 수 있다.")
	public void testCreateChangeSafeEmpty() {
	    // given
		ChangeSafe changeSafe = new ChangeSafe();
	    // when
		String string = changeSafe.toString();
		// then
		assertEquals("500원 - 0개\n"
			+ "100원 - 0개\n"
			+ "50원 - 0개\n"
			+ "10원 - 0개", string);
	}
}