package vendingmachine.model;

import vendingmachine.util.StringChecker;

public class Name {

	private String name;

	public Name(String input) {
		checkInput(input);
		name = input;
	}

	private void checkInput(String input) {
		StringChecker stringChecker = new StringChecker();
		stringChecker.isEmpty(input);
		stringChecker.containSpace(input);
		stringChecker.containTap(input);
	}
}
