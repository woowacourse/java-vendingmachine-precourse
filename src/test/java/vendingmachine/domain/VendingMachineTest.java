package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.constant.ErrorConst;

class VendingMachineTest {
	@DisplayName("상품을 구매할 수 있다.")
	@Test
	public void successBuyTest() throws Exception {
		//given
		VendingMachine vendingMachine = new VendingMachine(1000);
		vendingMachine.initItemList(
			Arrays.asList(new Item("콜라", 1500, 10),
				new Item("사이다", 1000, 30))
		);
		vendingMachine.inputAmount(3000);
		//when
		vendingMachine.buy("콜라");
		vendingMachine.buy("사이다");
		//then
		assertEquals(vendingMachine.getAmount(), 500);
	}

	@DisplayName("실패 : 재고가 없는 상품은 구매할 수 없다.")
	@Test
	public void failBuyNoStock() throws Exception {
		//given
		VendingMachine vendingMachine = new VendingMachine(1000);
		vendingMachine.initItemList(
			Arrays.asList(new Item("콜라", 1500, 0),
				new Item("사이다", 1000, 10))
		);
		vendingMachine.inputAmount(3000);
		//when
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> vendingMachine.buy("콜라"));
		assertEquals(exception.getMessage(), ErrorConst.HAVE_NO_STOCK);
	}

	@DisplayName("실패 : 투입한 금액보다 비싼 상품은 구매할 수 없다.")
	@Test
	public void failBuyNoMoney() throws Exception {
		//given
		VendingMachine vendingMachine = new VendingMachine(1000);
		vendingMachine.initItemList(
			Arrays.asList(new Item("콜라", 1500, 30),
				new Item("사이다", 500, 10))
		);
		vendingMachine.inputAmount(500);
		//when
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
			() -> vendingMachine.buy("콜라"));
		assertEquals(exception.getMessage(), ErrorConst.HAVE_NO_AFFORDABLE_MONEY);
	}

}