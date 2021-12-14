package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MachineTest {
	private final List<String> item = new ArrayList<>();
	private final List<String> itemCountZero = new ArrayList<>();
	private final Machine machine = new Machine();

	MachineTest() {
		item.add("[콜라,1000,3]");
		item.add("[사이다,2000,3]");
		itemCountZero.add("[콜라,1000,0]");
		itemCountZero.add("[사이다,2000,0]");
	}

	@Test
	void 잔돈_생성_테스트() {
		machine.setCoins(450);
		System.out.println(machine.getCoinList());
	}

	@Test
	void 잔돈_반환_시점_테스트_가격() {
		machine.setMerchandise(item);
		machine.setPayment("500");
		assert machine.checkAbleToBuyAnyItem() == false;
	}

	@Test
	void 잔돈_반환_시점_테스트_수량() {
		machine.setMerchandise(itemCountZero);
		machine.setPayment("2000");
		assert machine.checkAbleToBuyAnyItem() == false;
	}

	@Test
	void 잔돈_반환_시점_테스트_성공() {
		machine.setMerchandise(item);
		machine.setPayment("2000");
		assert machine.checkAbleToBuyAnyItem();
	}

	@Test
	void 잔돈_최소개수_반환_테스트() {
		machine.setCoins(1050);
		System.out.println(machine.getCoinList());
		machine.setPayment("800");
		System.out.println(machine.getReturnChange());
	}
}