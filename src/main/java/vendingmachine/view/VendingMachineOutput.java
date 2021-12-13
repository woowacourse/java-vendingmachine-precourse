package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.utils.VendingMachineMessage;

/**
 * <h1>자판기 로직 수행 결과를 출력한다</h1>
 *
 * @author yunki kim
 * @version 2.0
 * @since 2021-12-13(V1.0)
 */

public class VendingMachineOutput {

	public void printCoinTypesAmount(final HashMap<Integer, Integer> coinTypesAmount) {
		VendingMachineMessage.printCoinTypesAmount(coinTypesAmount);
	}

	public void printUserInputtedMoney(final int userInputtedMoney) {
		VendingMachineMessage.printUserInputtedMoney(userInputtedMoney);
	}

	public void printChanges(final HashMap<Integer, Integer> changes) {
		VendingMachineMessage.printChange(changes);
	}
}
