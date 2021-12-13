package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.config.ServiceConfig;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Quantity;

class ChangeSafeServiceTest {

	ChangeSafeService changeSafeService = ServiceConfig.getChangeSafeService();
	@Test
	@DisplayName("코인맵으로 금고를 생성한다.")
	public void testPersist() {
		// given
		Map<Coin, Quantity> coinMap = new LinkedHashMap<>();
		coinMap.put(Coin.COIN_500, new Quantity(1));
		coinMap.put(Coin.COIN_100, new Quantity(3));

		// when
		String persist = changeSafeService.persist(coinMap);
		// then
		assertEquals("50 - 0개\n"
			+ "100 - 3개\n"
			+ "10 - 0개\n"
			+ "500 - 1개", persist);
	}
}