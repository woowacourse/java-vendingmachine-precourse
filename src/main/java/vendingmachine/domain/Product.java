package vendingmachine.domain;

import java.util.Objects;

public class Product implements Comparable<Product> {
	private final Name name;
	private Amount amount;
	private Count count;

	public Product(String name, String amount, String count) {
		this.name = Name.of(name);
		this.amount = Amount.of(amount);
		this.count = Count.of(count);
	}

	// 살리면 Util로 옮기기
	private int convertStringToInt(String value) {
		return Integer.parseInt(value);
	}

	// TODO 3: 숫자래핑변수의 default값 없이  둘다 정보를 받으면, 파라미터를 수정한다. -> 생성자 파라미터도 수정한다.
	// -> 외부에서 들어오는건 원시타입으로 들어오기.. -> 래핑은.. 생성자에서 검증된 것을 of ( ) 로 싸서 래핑한다.
	public static Product of(String name, String amount, String count) {
		// TODO 4: 필요시 검증
		// checkProductValidation(name);
		return new Product(name, amount, count);
	}

	public int toAmount() {
		return this.amount.toInt();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product)o;
		return Objects.equals(name, product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public int compareTo(Product o) {
		return Integer.compare(this.amount.toInt(), o.amount.toInt());
	}

	public int toCount() {
		return this.count.toInt();
	}

	@Override
	public String toString() {
		return this.name.toString();
	}
}
