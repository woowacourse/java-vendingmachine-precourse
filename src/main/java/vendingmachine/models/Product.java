package vendingmachine.models;

/**
 * <h1>자판기 내부에 있는 각 제품의 정보</h1>
 * 자판기에서 판매하는 제품 하나에 대한 정보
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-11
 */

public class Product {

	private static final Integer MIN_PRODUCT_AMOUNT = 0;

	private final String name;

	private final Integer price;

	private int amount;

	public Product(final String name, final Integer price, final Integer amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if(amount < MIN_PRODUCT_AMOUNT) {
			return;
		}
		this.amount = amount;
	}

}

