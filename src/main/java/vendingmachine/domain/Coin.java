package vendingmachine.domain;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10),
	;
	public static final String WON_500 = "500원";
	public static final String WON_100 = "100원";
	public static final String WON_50 = "50원";
	public static final String WON_10 = "10원";


	private final int amount;

	Coin(final int amount) {
		this.amount = amount;
	}

	// 추가 기능 구현

	public int getAmount() {
		return amount;
	}

	public static Coin valueOf(int value) {
		for (Coin coin : Coin.values()) {
			if (coin.getAmount() == value) {
				return coin;
			}
		}
		return null;
	}

	public static String getKoreanValue(Coin coin) {
		if (coin == COIN_500) {
			return WON_500;
		}
		if (coin == COIN_100) {
			return WON_100;
		}
		if (coin == COIN_50) {
			return WON_50;
		}
		if (coin == COIN_10) {
			return WON_10;
		}
		return null;
	}

}
