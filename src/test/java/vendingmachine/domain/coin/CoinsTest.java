package vendingmachine.domain.coin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.exceptions.NotDivisibleByMinPriceCoinException;

class CoinsTest {
	@ParameterizedTest
	@ValueSource(strings = {"", "낫정수"})
	void validateEmptyOrNotInteger(String input) {
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			Coins.generateCoinsRandomlyFromTotalAmount(input)
		);

		assertEquals("[ERROR] 보유 금액은 정수입니다.", exception.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "3"})
	void validateLessThanMinPriceCoin(String input) {
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			Coins.generateCoinsRandomlyFromTotalAmount(input)
		);

		assertEquals("[ERROR] 보유 금액은 10원 이상입니다.", exception.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = {"11", "113"})
	void validateNotDivisibleByMinPriceCoin(String input) {
		Throwable exception = assertThrows(NotDivisibleByMinPriceCoinException.class, () ->
			Coins.generateCoinsRandomlyFromTotalAmount(input)
		);

		assertEquals("[ERROR] 보유 금액은 10원의 배수입니다.", exception.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = {"1000", "1110", "540", "1500"})
	void validateTotalAmount(String input) {
		Coins coins = Coins.generateCoinsRandomlyFromTotalAmount(input);

		assertEquals(coins.getTotalAmount(), Integer.parseInt(input));
	}
}