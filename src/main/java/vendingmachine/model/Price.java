package vendingmachine.model;

public class Price {

	private int price;

	public void set(String input) {
		checkInput(input);
		price = Integer.valueOf(input);
	}

	private void checkInput(String input) {

	}
}
