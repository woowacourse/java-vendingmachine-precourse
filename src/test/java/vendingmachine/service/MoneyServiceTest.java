package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.config.ServiceConfig;
import vendingmachine.domain.Money;

class MoneyServiceTest {

	MoneyService moneyService = ServiceConfig.getMoneyService();

	@Test
	@DisplayName("입력받은 문자열로 금액을 생성한다.")
	public void testMoneyCreation() {
		// given
		String input = "100";
	    // when
		Money money = moneyService.generateMoney(input);
	    // then
		assertEquals(new Money(100), money);
	}

	@Test
	@DisplayName("문자열이 비어있으면 에러를 던진다.")
	public void testMoneyWithEmpty() {
	    // given
	    String input = "";
		// then
		assertThrows(IllegalArgumentException.class, () -> moneyService.generateMoney(input));
	}

	@Test
	@DisplayName("문자열이 null이면 에러를 던진다")
	public void testMoneyWithNull() {
		// given
		String input = null;
		// then
		assertThrows(IllegalArgumentException.class, () -> moneyService.generateMoney(input));
	}

	@Test
	@DisplayName("문자열이 2^31 이상이면 에러를 던진다")
	public void testMoneyWithOverflow() {
	    // given
		String input = "2147483648";
	    // then
		assertThrows(IllegalArgumentException.class, () -> moneyService.generateMoney(input));
	}
}