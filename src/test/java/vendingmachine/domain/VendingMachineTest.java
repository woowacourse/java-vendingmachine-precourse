package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.menu.Menus;

class VendingMachineTest {
	VendingMachine vendingMachine;

	@BeforeEach
	void setUpVendingMachine() {
		Coins coins = Coins.generateCoinsRandomlyFromTotalAmount("1000");
		Menus menus = Menus.from("[콜라,300,2];[사이다,400,15];[데자와,3500,3]");

		vendingMachine = new VendingMachine(coins, menus);
		vendingMachine.putMoney("3000");
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "오백원", "500원"})
	void validateNumber(String input) {

		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			vendingMachine.putMoney(input)
		);

		assertEquals("[ERROR] 투입 금액은 정수입니다.", exception.getMessage());
	}

	@Test
	void buyTest() {
		vendingMachine.buy("콜라");
		assertEquals(vendingMachine.getInputMoney(), 2700);

		vendingMachine.buy("콜라");
		assertEquals(vendingMachine.getInputMoney(), 2400);

		vendingMachine.buy("사이다");
		assertEquals(vendingMachine.getInputMoney(), 2000);

		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			vendingMachine.buy("콜라")
		);
		assertEquals("[ERROR] 품절 상품입니다.", exception.getMessage());
	}

	@Test
	void validateMenuPriceTest() {

		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			vendingMachine.buy("데자와")
		);
		assertEquals("[ERROR] 투입 금액 이하의 메뉴를 선택해주세요.", exception.getMessage());
	}

}