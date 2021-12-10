package vendingmachine.domain.coin;

import java.util.Objects;

public class CoinAmount {
	private final int coinAmount;

	private CoinAmount(int coinAmount) {
		this.coinAmount = coinAmount;
	}

	public static CoinAmount from(int coinAmount) {
		return new CoinAmount(coinAmount);
	}

	public int toInt() {
		return this.coinAmount;
	}

	@Override
	public String toString() {
		return Integer.toString(coinAmount);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		CoinAmount that = (CoinAmount)object;
		return coinAmount == that.coinAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coinAmount);
	}
}
