package vendingmachine.dto;

import vendingmachine.domain.coins.Coins;

public class VendingMachineBalanceDto {
	private String balance;

	private VendingMachineBalanceDto(String balance) {
		this.balance = balance;
	}

	public static VendingMachineBalanceDto from(String balance) {
		return new VendingMachineBalanceDto(balance);
	}

	public Coins toCoinsEntity() {
		return Coins.from(this.balance);
	}
}
