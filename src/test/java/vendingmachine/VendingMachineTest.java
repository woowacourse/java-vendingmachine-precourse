package vendingmachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VendingMachineTest {
	final String notNumber = "notNumber";
	final String isNumber = "123";
	final String isRightNumber = "100";
	@Test
	void ChangeMaketest1() {
		assertThrows(IllegalArgumentException.class,()->new VendingMachine(notNumber) );
	}
	@Test
	void ChangeMaketest2() {
		assertThrows(IllegalArgumentException.class,()->new VendingMachine(isNumber) );
	}
	@Test
	void ChangeMaketest3() {
		assertDoesNotThrow(()->new VendingMachine(isRightNumber) );
	}

}
