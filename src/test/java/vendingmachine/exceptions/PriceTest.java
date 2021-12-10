package vendingmachine.exceptions;

import static constant.StringConstant.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exception.PriceException;

public class PriceTest {

	@Test
	void isPriceNumberTest() {
		//given
		String userInput = "백원";

		//when

		//then
		assertThatThrownBy(() -> {
			PriceException.isValidPrice(userInput);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_NUMBER);
	}

	@Test
	void isPricePositiveTest() {
		//given
		String userInput = "-1";

		//when

		//then
		assertThatThrownBy(() -> {
			PriceException.isValidPrice(userInput);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_POSITIVE);
	}

	@Test
	void isPriceCoinValueTest() {
		//given
		String userInput = "111";

		//when

		//then
		assertThatThrownBy(() -> {
			PriceException.isValidPrice(userInput);})
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NOT_COIN_VALUE);
	}

}
