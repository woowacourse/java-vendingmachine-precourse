package vendingmachine.domain;

public class Price {
	public final int price;

	public Price(int price) {
		this.price = price;
	}

	public static Price from(String price) {
		return new Price(Integer.parseInt(price));
	}
}
