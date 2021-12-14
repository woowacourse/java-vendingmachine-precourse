package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.constant.ErrorMessage.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.view.InputView;

class ItemTest {

	@Test
	void 상품입력_정상_1() {
		List<Item> items = InputView.getItems("[콜라,1500,20];[사이다,1000,10];[핫식스,1200,30]");
		assertThat(items).contains(
			new Item("콜라", 1500, 20),
			new Item("사이다", 1000, 10),
			new Item("핫식스", 1200, 30)
		);
	}

	@Test
	void 상품입력_예외_1() {
		assertThatThrownBy(() -> InputView.getItems("[콜라,1500,20];[사이다,1000,10];"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_INVALID_BRACKETS);
	}

	@ParameterizedTest
	@ValueSource(strings = {"[콜라,15a,20];[사이다,1000,10]", "[콜라,,20]"})
	void 상품입력_예외2(String input) {
		assertThatThrownBy(() -> InputView.getItems(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_INVALID_ITEM_FORMAT);
	}
}