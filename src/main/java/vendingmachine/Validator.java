package vendingmachine;

public abstract class Validator {
	public void isMoreThanThreshold(int number, int threshold, Error error) throws IllegalArgumentException {
		if (number < threshold) {
			throw new IllegalArgumentException(error.getMessage());
		}
	}
}
