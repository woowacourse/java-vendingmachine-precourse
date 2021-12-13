package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.models.VendingMachine;
import vendingmachine.utils.VendingMachineMessage;

/**
 * <h1>자판기 로직 수행 결과를 출력한다</h1>
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-13(V1.0)
 */

public class VendingMachineOutput {

	private VendingMachine vendingMachine;

	public VendingMachineOutput(final VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	public void printCoinTypesAmount() {
		HashMap<Integer, Integer> coinTypesAmount = vendingMachine.getCoinTypesAmount();
		VendingMachineMessage.printCoinTypesAmount(coinTypesAmount);
	}

	public void printUserInputtedMoney() {
		final int userInputtedMoney = vendingMachine.getUserInputtedMoney();
		VendingMachineMessage.printUserInputtedMoney(userInputtedMoney);
	}

	public void printChanges(final HashMap<Integer, Integer> changes) {
		VendingMachineMessage.printChange(changes);
	}
}
