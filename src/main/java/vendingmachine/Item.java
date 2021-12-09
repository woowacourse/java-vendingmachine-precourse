package vendingmachine;

/**
 * 상품의 역할을 하는 model class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class Item {
	private final String name;
	private final int price;
	private int count;

	public Item(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public boolean isName(String name) {
		return this.name.equals(name);
	}
}
