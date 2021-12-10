package vendingmachine.model;

public class Number {

	private int number;

	public void set(String input) {
		checkInput(input);
		number = Integer.valueOf(input);
	}

	private void checkInput(String input) {

	}
}
