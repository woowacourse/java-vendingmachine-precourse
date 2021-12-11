package vendingmachine.domain;

public class Consumer {
	private int money;

	private Consumer(int money) {
		this.money = money;
	}

	public static Consumer create(int inputMoney) {
		return new Consumer(inputMoney);
	}
}
