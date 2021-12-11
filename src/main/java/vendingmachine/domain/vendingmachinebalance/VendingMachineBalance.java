package vendingmachine.domain.vendingmachinebalance;

import java.util.Objects;

import vendingmachine.validator.BalanceValidator;

public class VendingMachineBalance {
	private final int vendingMachineBalance;

	private VendingMachineBalance(int vendingMachineBalance) {
		this.vendingMachineBalance = vendingMachineBalance;
	}

	public static VendingMachineBalance from(int vendingMachineBalance) {
		BalanceValidator.validateVendingMachineBalance(vendingMachineBalance);
		return new VendingMachineBalance(vendingMachineBalance);
	}

	public int toInt() {
		return vendingMachineBalance;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		VendingMachineBalance that = (VendingMachineBalance)object;
		return vendingMachineBalance == that.vendingMachineBalance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(vendingMachineBalance);
	}

	@Override
	public String toString() {
		return Integer.toString(vendingMachineBalance);
	}
}
