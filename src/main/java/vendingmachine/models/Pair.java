package vendingmachine.models;

public class Pair {
	private int firstValue;
	private int secondValue;

	public Pair(int firstValue, int secondValue) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}

	public int getFirstValue() {
		return this.firstValue;
	}
}