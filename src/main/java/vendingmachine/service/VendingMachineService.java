package vendingmachine.service;

import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;

public class VendingMachineService {
	private static final String INSERT_MONEY_ERROR_MESSAGE = "금액이 부족합니다.";

	public static void insertMoney(VendingMachine vendingMachine, Money insertMoney) throws IllegalArgumentException {
		vendingMachine.insertMoney(insertMoney);
		if (vendingMachine.compareCheapestPrice(insertMoney) < 0) {
			throw new IllegalArgumentException();
		}
	}
}
