package vendingmachine.domain;

public class Merchandise {
	public static final int MERCHANDISE_NAME_INDEX = 0;
	public static final int MERCHANDISE_PRICE_INDEX = 1;
	public static final int MERCHANDISE_COUNT_INDEX = 2;
	private String name;
	private int price;
	private int count;

	public Merchandise(String item) {
		item = item.replace("[", "").replace("]", "");
		String[] elements = item.split(",");
		this.name = elements[MERCHANDISE_NAME_INDEX];
		this.price = Integer.parseInt(elements[MERCHANDISE_PRICE_INDEX]);
		this.count = Integer.parseInt(elements[MERCHANDISE_COUNT_INDEX]);
	}

}
