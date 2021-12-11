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

	public void notifyUserBalance(int userBalance) {
		print(String.format(OutputConstants.USER_BALANCE_STATEMENT, userBalance));
	}

	public void notifyChange(EnumMap<Coin, Integer> changeMap) {
		for(Coin coin : changeMap.keySet()) {
			notifyStorageCoinInLine(coin, changeMap.get(coin));
		}
	}

	private void print(String message) {
		System.out.println(message);
	}

	public void printLine() {
		System.out.println();
	}
}
