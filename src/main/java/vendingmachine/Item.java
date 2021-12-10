package vendingmachine;

/**
 * 상품의 역할을 하는 model class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Item {
	private final int price;
	private int count;

	public Item(int price, int count) {
		this.price = price;
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void takeOne() {
		count--;
	}
}
