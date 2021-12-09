package vendingmachine.domain.coinamount;

public class CoinAmount {
	private final int coinAmount;

	private CoinAmount(int coinAmount) {
		this.coinAmount = coinAmount;
	}

	public static CoinAmount from(int coinAmount) {
		return new CoinAmount(coinAmount);
	}

	@Override
	public String toString() {
		return Integer.toString(coinAmount);
	}
}
