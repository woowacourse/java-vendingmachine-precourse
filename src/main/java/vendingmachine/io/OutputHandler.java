package vendingmachine.io;

import java.util.Map;

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

	public void printErrorMessage(Exception exception) {
		printMessage(exception.getMessage());
	}

	public void printVendingMachineChanges(Map<Coin, Integer> coinMap) {
		printMessage(VendingMachineData.COIN_STATUS_MESSAGE);
		printCoinStatus(coinMap);
	}

	public void printReturnChanges(Map<Coin, Integer> coinMap) {
		printMessage(VendingMachineData.CHANGE_STATUS_MESSAGE);
		printCoinStatus(coinMap, false);
	}

	public void printBalance(int balance) {
		printMessage(String.format(VendingMachineData.MONEY_STATUS_MESSAGE, balance));
	}

	private void printCoinStatus(Map<Coin, Integer> coinMap) {
		printCoinStatus(coinMap, true);
	}

	private void printCoinStatus(Map<Coin, Integer> coinMap, boolean printZero) {
		for (Coin coin : Coin.getCoinList()) {
			if(!printZero && coinMap.get(coin) == 0) {
				continue;
			}
			printMessage(String.format(VendingMachineData.CHANGE_STATUS_FORMAT, coin.getAmount(), coinMap.get(coin)));
		}
	}

}
