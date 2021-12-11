package vendingmachine.domain;

public class InputMoney {
	private int currentMoney;

	public InputMoney(int currentMoney) {
		this.currentMoney = currentMoney;
	}

	public int getCurrentMoney() {
		return currentMoney;
	}
}
