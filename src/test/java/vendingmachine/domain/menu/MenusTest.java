package vendingmachine.domain.menu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.coin.Coins;

class MenusTest {
	@ParameterizedTest
	@ValueSource(strings = {"", ";", "상품정보1;상품정보2;", ";상품정보1;상품정보2"})
	void validateDelimetersTest(String input) {
		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			Menus.from(input)
		);

		assertEquals("[ERROR] 각 상품 정보는 세미콜론(;)으로 구분합니다.", exception.getMessage());
	}

	@Test
	void findMenuByNameTest() {
		Coins coins = Coins.generateCoinsRandomlyFromTotalAmount("1000");
		Menus menus = Menus.from("[콜라,300,2];[사이다,400,15]");

		VendingMachine vendingMachine = new VendingMachine(coins, menus);
		vendingMachine.putMoney("3000");
		assertEquals(vendingMachine.getInputMoney(), 2000);

		Throwable exception = assertThrows(IllegalArgumentException.class, () ->
			vendingMachine.buy("닥터페퍼")
		);
		assertEquals("[ERROR] 존재하지 않는 상품입니다.", exception.getMessage());
	}
}