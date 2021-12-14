package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Rollback;
import vendingmachine.config.ServiceConfig;
import vendingmachine.domain.Money;

class DepositServiceTest implements Rollback {

	DepositService service = ServiceConfig.getDepositService();

	@Test
	@DisplayName("금액을 저장한다.")
	public void testDeposit() {
	    // given
		Money money = new Money(1000);
		// then
		Money deposit = service.deposit(money);
		// then
		assertEquals("1000원", deposit.toString());
	}
}