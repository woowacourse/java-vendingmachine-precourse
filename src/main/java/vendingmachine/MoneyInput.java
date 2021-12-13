package vendingmachine;

public class MoneyInput {
	int money;
	public MoneyInput(String inputMoney) {
		this.money = Integer.parseInt(inputMoney);
	}
	
	public int getMoney() {
		return money;
	}
	//음료수 구매시 투입 금액 차감
	public void remainMoney(int cost) {
		this.money = this.money - cost;
	}
	
	
}
