package vendingmachine.controller;

public class PurchaseController {

	private int money;

	public PurchaseController() {
		money = 3000;
	}

	public String retrieveDeposit() {
		return "투입 금액: " + money + "원";
	}

	public boolean isAvailable() {
		return money > 1000;
	}

	public void purchase(String input) {
		if ("콜라".equals(input)) {
			money -= 1500;
		} else if ("사이다".equals(input)) {
			money -= 1000;
		}
	}

	public String retrieveChangeSafe() {
		return "잔돈\n100원 - 4개\n50원 - 1개";
	}
}
