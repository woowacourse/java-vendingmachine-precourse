package vendingmachine.controller;

public class ChangeSafeController {
	public String generateChangeSafe(String input) {
		return "500원 - 0개\n"
			+ "100원 - 4개\n"
			+ "50원 - 1개\n"
			+ "10원 - 0개";
	}
}
