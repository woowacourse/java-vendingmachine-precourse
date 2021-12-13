package vendingmachine.validation.enumclass;

public enum Constant {
	ZERO(0),
	THREE(3),
	TEN(10),
	HUNDRED(100);
	private final int number;

	Constant(final int number) {
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

}
