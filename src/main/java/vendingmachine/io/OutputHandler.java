package vendingmachine.io;

import java.util.Map;

import vendingmachine.VendingMachine;
import vendingmachine.data.VendingMachineData;
import vendingmachine.type.Coin;

public class OutputHandler {

	public void printMessage(String message) {
		System.out.println(message);
	}

	public void printMessageNoNewline(String message) {
		System.out.print(message);
	}

	public void printBlankLine() {
		System.out.println();
	}

	public void printErrorMEssage(Exception exception) {
		printMessage(exception.getMessage());
	}

	public void printVendingMachineChanges(Map<Coin, Integer> coinMap) {
		printMessage(VendingMachineData.COIN_STATUS_MESSAGE);
		printCoinStatus(coinMap);
	}

	private void printCoinStatus(Map<Coin, Integer> coinMap) {
		printCoinStatus(coinMap, true);
	}

	private void printCoinStatus(Map<Coin, Integer> coinMap, boolean printZero) {
		for (Coin coin : Coin.getCoinList()) {
			printMessage(String.format(VendingMachineData.CHANGE_STATUS_FORMAT, coin.getAmount(), coinMap.get(coin)));
		}
	}

}
