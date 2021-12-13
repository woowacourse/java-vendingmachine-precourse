package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProductTest {
	@DisplayName("이름은 빈값이면 안된다.")
	@Test
	void name() {
		assertThatThrownBy(() -> new Product("",new Money(1000),10))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("상품 가격은 100원 이상이어야 한다.")
	@Test
	void price() {
		assertThatThrownBy(() -> new Product("콜라", new Money(90), 10))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("수량은 0 이상의 값이다.")
	@Test
	void count() {
		assertThatThrownBy(() -> new Product("콜라", new Money(100), -1))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
