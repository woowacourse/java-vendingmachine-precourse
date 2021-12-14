package vendingmachine.domain.machine.product;

public enum ProductInformationCount {

	COUNT(3);

	private final int number;

	ProductInformationCount(int number) {
		this.number = number;
	}

	public static boolean isNotEquals(int number) {
		return (COUNT.number != number);
	}

}
