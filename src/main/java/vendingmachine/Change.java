package vendingmachine;

public class Change {
	private Change() {
	}

	public static void giveChange(CoinPocket pocket, int userMoney) {
		Guide.printLeftMoney(userMoney);
		Guide.USER_CHANGE_SHOW.println();
		CoinPocket change = calculateChange(pocket, userMoney);
		change.removeCoinsOfZeroNumber();
		Guide.printCoinPocket(change);
	}

	private static CoinPocket calculateChange(CoinPocket pocket, int userMoney) {
		CoinPocket change = new CoinPocket();
		for (Coin coin : Coin.values()) {
			int numberOfPoppedCoins = pocket.pop(coin, coin.divide(userMoney));
			userMoney = coin.subtractByGivenNumberOfCoins(userMoney, numberOfPoppedCoins);
			change.push(coin, numberOfPoppedCoins);
		}

		return change;
	}
}
