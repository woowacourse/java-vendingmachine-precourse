package vendingmachine.model;

public class TheNumber {

	private int theNumber;

	public void set(String input) {
		checkInput(input);
		theNumber = Integer.valueOf(input);
	}

	private void checkInput(String input) {

	}
}
