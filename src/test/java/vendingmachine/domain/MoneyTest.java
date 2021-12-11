package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {
	@Test
	void 생성() {
		// given
		String notNumber = "abc";
		String notDividedBy10 = "111";
		String negative = "-10";
		String rightAmount = "250";

		// when
		assertAll(
			() -> assertThatThrownBy(() -> new Money(notNumber)).isInstanceOf(IllegalArgumentException.class),
			() -> assertThatThrownBy(() -> new Money(notDividedBy10)).isInstanceOf(IllegalArgumentException.class),
			() -> assertThatThrownBy(() -> new Money(negative)).isInstanceOf(IllegalArgumentException.class),
			() -> assertThat(new Money(rightAmount)).isNotNull());
	}
}