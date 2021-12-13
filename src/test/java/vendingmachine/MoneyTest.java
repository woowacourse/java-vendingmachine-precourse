package vendingmachine;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MoneyTest {

	@Test
	void 금액이_음수인경우_에러() {
		assertThatThrownBy(() -> Money.from(-1))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
