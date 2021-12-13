package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {
	@DisplayName("돈은 10의 배수여야 한다.")
	@Test
	void isDivideByTen() {
		assertThatThrownBy(() -> new Money(9))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("돈은 10의 배수여야 한다.");
	}
}
