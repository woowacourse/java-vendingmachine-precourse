package vendingmachine.domain.money;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.constant.Notification;

class MoneyTest {
	@Test
	@DisplayName("금액은 int로 만들 수 없는 문자열이 올 수 없다.")
	public void validateString() {
		try {
			Money.of("2147483648");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(e.getMessage(), Notification.AMOUNT_CONVERT_FAILURE.getMessage());
		}
	}

	@Test
	@DisplayName("금액은 0보다 작을 수 없다.")
	public void validateRange() {
		try {
			Money.of("-25");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(e.getMessage(), Notification.AMOUNT_EXCEED_RANGE.getMessage());
		}
	}

	@Test
	@DisplayName("금액은 최소 단위보다 작을 수 없다.")
	public void validateMinimumUnit() {
		try {
			Money.of("2333");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(e.getMessage(), Notification.AMOUNT_SMALLER_MINIMUM_UNIT.getMessage());
		}
	}
}
