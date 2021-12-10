package vendingmachine.domain;

public class VendingMachine {
	private Coins leftCoins;

	public VendingMachine(Coins leftCoins) {
		this.leftCoins = leftCoins;
	}

	public VendingMachine(String initalLeftMoney) {
		validateInitialLeftMoney(initalLeftMoney);
	}

	private void validateInitialLeftMoney(String initialLeftMoney) {}
}

