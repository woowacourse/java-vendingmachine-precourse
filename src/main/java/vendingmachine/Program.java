package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Program {
	public final CoinPocket pocket;

	public Program() {
		pocket = new CoinPocket();
		int initialMoney = setInitialMoney();
		makeRandomCoins(initialMoney);
		Message.printCoinPocket(pocket);
	}

	private int setInitialMoney() {
		Message.INITIAL_MONEY_REQUEST.println();
		String moneyInString = Console.readLine();
		return Integer.parseInt(moneyInString);
	}

	private void makeRandomCoins(int money) {
		while (Coin.isSwappableForCoin(money)) {
			Coin coin = Coin.random(money);
			pocket.push(coin);
			money = coin.subtract(money);
		}
	}
}
