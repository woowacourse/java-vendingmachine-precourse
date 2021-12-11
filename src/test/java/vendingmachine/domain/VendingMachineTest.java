package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.menu.Menus;

class VendingMachineTest {
	@ParameterizedTest
	@ValueSource(strings = {"", "오백원", "500원"})
	void validateNumber(String input) {
		Coins coins = Coins.generateCoinsRandomlyFromTotalAmount("1000");
		Menus menus = Menus.from("[상품명,300,10];[상품명2,400,15]");

		VendingMachine vendingMachine = new VendingMachine(coins, menus);

		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			vendingMachine.putMoney(input)
		);

		assertEquals("[ERROR] 투입 금액은 정수입니다.", exception.getMessage());
	}
}