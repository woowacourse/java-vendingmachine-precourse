package vendingmachine.domain.userbalance;

import java.util.Objects;

import vendingmachine.domain.item.Item;
import vendingmachine.domain.item.ItemPrice;
import vendingmachine.validator.BalanceValidator;

public class UserBalance {
	private final int userBalance;

	private UserBalance(int userBalance) {
		this.userBalance = userBalance;
	}

	public static UserBalance from(int userBalance) {
		BalanceValidator.validateUserBalance(userBalance);
		return new UserBalance(userBalance);
	}

	public UserBalance subtract(ItemPrice itemPrice) {
		return new UserBalance(userBalance - itemPrice.toInt());
	}

	public boolean canBuy(Item item) {
		return userBalance >= item.getItemPrice().toInt();
	}

	public int toInt() {
		return this.userBalance;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		UserBalance that = (UserBalance)object;
		return userBalance == that.userBalance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userBalance);
	}

	@Override
	public String toString() {
		return Integer.toString(this.userBalance);
	}
}
