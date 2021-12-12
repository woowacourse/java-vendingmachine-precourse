package vendingmachine.dto;

import vendingmachine.domain.vendingmachinebalance.VendingMachineBalance;

public class VendingMachineBalanceDto {
	private final int vendingMachineBalance;

	private VendingMachineBalanceDto(int vendingMachineBalance) {
		this.vendingMachineBalance = vendingMachineBalance;
	}

	public static VendingMachineBalanceDto from(int vendingMachineBalance) {
		return new VendingMachineBalanceDto(vendingMachineBalance);
	}

	public VendingMachineBalance toEntity() {
		return VendingMachineBalance.from(vendingMachineBalance);
	}
}
