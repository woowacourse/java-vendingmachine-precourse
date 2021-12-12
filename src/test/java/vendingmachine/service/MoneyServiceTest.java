package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.config.ServiceConfig;
import vendingmachine.domain.Money;

class MoneyServiceTest {

	@Test
	@DisplayName("입력받은 문자열로 금액을 생성한다.")
	public void testMoneyCreation() {
	    // given
		String input = "100";
	    MoneyService moneyService = ServiceConfig.getMoneyService();
	    // when
		Money money = moneyService.generateMoney(input);
	    // then
		assertEquals(new Money(100), money);
	}
}