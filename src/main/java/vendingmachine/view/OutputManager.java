package vendingmachine.view;

import java.util.EnumMap;

import vendingmachine.constants.ViewConstants;
import vendingmachine.enums.Coin;

public class OutputManager {

	public void notifyStorageCoinStart() {
		print(ViewConstants.COIN_QUANTITY_START);
	}

	public void notifyQuantityByCoin(Coin coin, int quantity) {
		String quantityAnnouncement = String.format(ViewConstants.COIN_QUANTITY_STATEMENT, coin.getAmount(), quantity);
		print(quantityAnnouncement);
	}

	public void notifyUserBalance(int userBalance) {
		print(String.format(ViewConstants.USER_BALANCE_STATEMENT, userBalance));
	}

	public void notifyChangeStart() {
		print(ViewConstants.COIN_CHANGE);
	}

	public void notifyChange(EnumMap<Coin, Integer> changeMap) {
		for(Coin coin : changeMap.keySet()) {
			notifyQuantityByCoin(coin, changeMap.get(coin));
		}
	}

	private void print(String message) {
		System.out.println(message);
	}

	public void printLine() {
		System.out.println();
	}
}
