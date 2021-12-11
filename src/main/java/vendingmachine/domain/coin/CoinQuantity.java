package vendingmachine.domain.coin;

import java.util.Objects;

public class CoinQuantity {
	private final int coinQuantity;

	private CoinQuantity(int coinQuantity) {
		this.coinQuantity = coinQuantity;
	}

	public static CoinQuantity from(int coinQuantity) {
		return new CoinQuantity(coinQuantity);
	}

	public int toInt() {
		return this.coinQuantity;
	}

	@Override
	public String toString() {
		return Integer.toString(coinQuantity);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		CoinQuantity that = (CoinQuantity)object;
		return coinQuantity == that.coinQuantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coinQuantity);
	}
}
