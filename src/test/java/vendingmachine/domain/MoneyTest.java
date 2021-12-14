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

	@DisplayName("더하기")
	@Test
	void plus() {
		Money money = new Money(100);
		assertThat(money.plus(new Money(100)).compareTo(new Money(200))).isEqualTo(0);
	}

	@DisplayName("빼기")
	@Test
	void subtract() {
		Money money = new Money(100);
		assertThat(money.subtract(new Money(100)).compareTo(new Money(0))).isEqualTo(0);
	}
}
