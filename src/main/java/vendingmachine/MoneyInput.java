package vendingmachine;

public class MoneyInput {
	int money;

	public MoneyInput(String inputMoney) {
		this.money = Integer.parseInt(inputMoney);
	}

	public int getMoney() {
		return money;
	}

	public void remainMoney(int cost) {
		this.money = this.money - cost;
	}

}
