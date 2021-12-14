package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Rollback;
import vendingmachine.config.ServiceConfig;
import vendingmachine.domain.ChangeSafe;
import vendingmachine.domain.Money;

class ChangeSafeServiceTest implements Rollback {

	ChangeSafeService service = ServiceConfig.getChangeSafeService();

	@Test
	@DisplayName("금액으로 잔돈 금고를 생성한다.")
	public void testPersist() {
		// given
		Money money = new Money(1000);
		// when
		ChangeSafe changeSafe = service.generateChangeSafe(money);
		// then
		assertTrue(changeSafe.toString().contains("500원"));
	}

	@Test
	@DisplayName("잔돈을 돌려받는다.")
	public void testGiveChange() {
		// given
		Money money = new Money(300);
		// when
		ChangeSafe changeSafe = service.giveChange(money);
		// then
		assertEquals("500원 - 0개\n"
			+ "100원 - 3개\n"
			+ "50원 - 0개\n"
			+ "10원 - 0개", changeSafe.toString());
	}

	@Test
	@DisplayName("반환할 수 있는 잔돈만 반환한다.")
	public void testGiveChangeOver() {
		// given
		Money money = new Money(500);
		// when
		ChangeSafe changeSafe = service.giveChange(money);
		// then
		assertEquals("500원 - 0개\n"
			+ "100원 - 4개\n"
			+ "50원 - 1개\n"
			+ "10원 - 0개", changeSafe.toString());
	}
}