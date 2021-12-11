package vendingmachine.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("VendingMachineMessage 클래스")
class VendingMachineMessageTest {

	@DisplayName("유저가 입력해야 하는 데이터를 안내하는 메시지가 정상적으로 가져와 지는지 확인")
	@Test
	void validateInputMessage() {
		assertEquals("자판기가 보유하고 있는 금액을 입력해 주세요.",
			VendingMachineMessage.INPUT_AMOUNT_MONEY_IN_MACHINE);
		assertEquals("상품명과 가격, 수량을 입력해 주세요.",
			VendingMachineMessage.INPUT_PRODUCTS_INFORMATION);
		assertEquals("투입 금액을 입력해 주세요.",
			VendingMachineMessage.INPUT_MONEY);
		assertEquals("구매할 상품명을 입력해 주세요.",
			VendingMachineMessage.SELECT_PRODUCT_TO_PURCHASE);
	}
}
