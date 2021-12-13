package vendingmachine.domain.machine;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.product.Products;

class VendingMachineTest {

	@Test
	void 상품_구매_테스트() {
		// given
		VendingMachine vendingMachine = VendingMachine.of(
			Coins.from(450), Products.from(Arrays.asList("콜라,2000,2")), Balance.from(3000));

		// when
		vendingMachine.purchaseProduct("콜라");

		// then
		assertTrue(vendingMachine.getHasBalance().equals(Balance.from(1000)));
	}

	@Test
	void 상품_구매_실패_테스트() {
		// given
		VendingMachine vendingMachine = VendingMachine.of(
			Coins.from(450), Products.from(Arrays.asList("콜라,2000,2")), Balance.from(1000));

		// when // then
		assertThrows(IllegalArgumentException.class, () -> {
			vendingMachine.purchaseProduct("콜라");
		});
	}

	@Test
	void 자판기_동작_가능여부_테스트() {
		// given
		VendingMachine vendingMachine = VendingMachine.of(
			Coins.from(450), Products.from(Arrays.asList("콜라,2000,2")), Balance.from(3000));

		// when // then
		assertTrue(vendingMachine.isContinueVendingMachine());
	}

	@Test
	void 자판기_동작_가능여부_잔액으로_인한_실패_테스트() {
		// given
		VendingMachine vendingMachine = VendingMachine.of(
			Coins.from(450), Products.from(Arrays.asList("콜라,2000,2")), Balance.from(1000));

		// when // then
		assertFalse(vendingMachine.isContinueVendingMachine());
	}

	@Test
	void 자판기_동작_가능여부_상품수량으로_인한_실패_테스트() {
		// given
		VendingMachine vendingMachine = VendingMachine.of(
			Coins.from(450), Products.from(Arrays.asList("콜라,2000,1")), Balance.from(6000));

		vendingMachine.purchaseProduct("콜라");

		// when // then
		assertFalse(vendingMachine.isContinueVendingMachine());
	}
}
