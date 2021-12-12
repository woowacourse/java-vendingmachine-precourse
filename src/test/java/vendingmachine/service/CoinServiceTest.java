package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.config.ServiceConfig;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;

class CoinServiceTest {

	CoinService service = ServiceConfig.getCoinService();

	@Test
	@DisplayName("금액으로부터 코인을 랜덤으로 생성한다.")
	public void testGenerateCoinMapFromMoney() {
		// given
		Money money = new Money(100);
		// when
		Map<Coin, Integer> map = service.generateCoinMap(money);
		// then
		assertFalse(map.isEmpty());
	}

	@Test
	@DisplayName("금액이 0원이면 코인이 없다.")
	public void testGenerateCoinMapFromZero() {
		// given
		Money money = new Money(0);
		// when
		Map<Coin, Integer> map = service.generateCoinMap(money);
		// then
		assertTrue(map.isEmpty());
	}
}