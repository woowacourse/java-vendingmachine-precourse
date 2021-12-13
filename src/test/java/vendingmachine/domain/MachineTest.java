package vendingmachine.domain;

import org.junit.jupiter.api.Test;

class MachineTest {
	private static final String MERCHANDISE = "[콜라,1000,3];[사이다,2000,3]";
	private static final String MERCHANDISE_COUNT_ZERO = "[콜라,1000,0];[사이다,2000,0]";
	private final Machine machine = new Machine();

	@Test
	void 잔돈_생성_테스트() {
		machine.setCoins(450);
		System.out.println(machine.getSortedCoinCount());
	}

	@Test
	void 잔돈_반환_시점_테스트_가격() {
		machine.setMerchandise(MERCHANDISE);
		machine.setPayment("500");
		assert machine.checkAbleToBuyItem() == false;
	}

	@Test
	void 잔돈_반환_시점_테스트_수량() {
		machine.setMerchandise(MERCHANDISE_COUNT_ZERO);
		machine.setPayment("2000");
		assert machine.checkAbleToBuyItem() == false;
	}

	@Test
	void 잔돈_반환_시점_테스트_성공() {
		machine.setMerchandise(MERCHANDISE);
		machine.setPayment("2000");
		assert machine.checkAbleToBuyItem();
	}

	@Test
	void 잔돈_최소개수_반환_테스트() {
		machine.setCoins(1050);
		System.out.println(machine.getSortedCoinCount());
		machine.setPayment("1200");
		System.out.println(machine.getReturnCoins());
	}
}