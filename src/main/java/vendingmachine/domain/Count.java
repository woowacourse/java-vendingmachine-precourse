package vendingmachine.domain;

public class Count {
	private final int count;

	Count(int count) {
		this.count = count;
	}

	public Count add(int amount) {
		return new Count(this.count + amount);
	}

	public Count reduce(int amount) {
		return new Count(this.count - amount);
	}

	public int getCount() {
		return count;
	}
}
