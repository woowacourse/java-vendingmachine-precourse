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

	public int getSecondValue() {
		return this.secondValue;
	}

	public void increaseSecondValue(int amount) {
		this.secondValue += amount;
	}

	public void decreaseSecondValue(int amount) {
		this.secondValue -= amount;
	}
}