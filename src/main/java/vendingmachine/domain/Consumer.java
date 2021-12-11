package vendingmachine.domain;

public class Consumer {
	private int money;

	private Consumer(int money) {
		this.money = money;
	}

	public static Consumer create(int inputMoney) {
		return new Consumer(inputMoney);
	}

	public boolean cannotBuy(Item item) {
		return money < item.getPrice();
	}

	public void buy(Item item) {
		this.money -= item.getPrice();
	}

	public int getMoney() {
		return money;
	}
}
