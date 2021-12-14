package vendingmachine.domain.enumclass;

public enum ProductEnum {

	NAME(0),
	PRICE(1),
	AMOUNT(2);

	private final int index;

	ProductEnum(final int index) {
		this.index = index;
	}

	public int getIndex(){
		return index;
	}
}
