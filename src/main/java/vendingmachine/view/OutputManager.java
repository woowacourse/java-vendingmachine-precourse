package vendingmachine.view;

import java.util.EnumMap;

import vendingmachine.constants.OutputConstants;
import vendingmachine.enums.Coin;

public class OutputManager {

	public void notifyStorageCoinStart() {
		print(OutputConstants.COIN_QUANTITY_START);
	}

	public void notifyStorageCoinInLine(Coin coin, int quantity) {
		String line = String.format(OutputConstants.COIN_QUANTITY_STATEMENT, coin.getAmount(), quantity);
		print(line);
	}

	private void print(String message) {
		System.out.println(message);
	}

	public void printLine() {
		System.out.println();
	}
}
