package vendingmachine.domain;

public class InsertMoney {
	private int currentMoney;

	public InsertMoney(int currentMoney) {
		this.currentMoney = currentMoney;
	}

	public int getCurrentMoney() {
		return currentMoney;
	}

	public void reduceMoney(int productPrice) {
		currentMoney -= productPrice;
	}
}
