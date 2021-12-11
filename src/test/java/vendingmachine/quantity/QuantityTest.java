package vendingmachine.quantity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuantityTest {
	@Test
	@DisplayName("개수가 최소에서 더 줄어들 수 없다.")
	public void decreaseCountAtMinimum() {
		Quantity quantity = Quantity.from();
		Assertions.assertThrows(ArithmeticException.class, quantity::down);
	}

	@Test
	@DisplayName("개수가 초대에서 더 증가할 수 없다.")
	public void increaseCountAtMaximum() {
		Quantity quantity = Quantity.of(String.valueOf(Integer.MAX_VALUE));
		Assertions.assertThrows(ArithmeticException.class, quantity::up);
	}

	@Test
	@DisplayName("개수는 int로 나타낼 수 있는 수만 들어올 수 있다.")
	public void validateStringCount() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> Quantity.of("test"));
	}

	@Test
	@DisplayName("개수는 Quantity의 범위 내만 들어올 수 있다.")
	public void validateStringNegative() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> Quantity.of("-1"));
	}
}
