package vendingmachine.service;

import vendingmachine.domain.Changes;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;

public class VendingMachineService {
	private static final String INSERT_MONEY_ERROR_MESSAGE = "금액이 부족합니다.";

	public static void insertMoney(VendingMachine vendingMachine, Money insertMoney) throws IllegalArgumentException {
		vendingMachine.deposit(insertMoney);
		if (!vendingMachine.isBuy()) {
			throw new IllegalArgumentException(INSERT_MONEY_ERROR_MESSAGE);
		}
	}

	public static void buyForName(VendingMachine vendingMachine, String name) {
		if (vendingMachine.isBuy(name)) {
			vendingMachine.buy(name);
		}
	}

	public static Changes returnChanges(VendingMachine vendingMachine) {
		return vendingMachine.returnChanges();
	}
}
