package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemTest {

	@DisplayName("상품명, 가격, 수량 입력이 유효한 조건의 값일 경우 Item 객체를 생성한다")
	@Test
	public void createItem() {
		List<String> details = Arrays.asList("콜라", "1500", "10");
		assertThatCode(() -> new Item(details))
			.doesNotThrowAnyException();
	}

	@DisplayName("상품명, 가격, 수량 입력이 유효한 조건의 값이 아닌 경우 예외를 발생시킨다")
	@Test
	public void createItemException() {
		List<List<String>> detailsCases = new ArrayList<>();
		detailsCases.add(Arrays.asList("콜라", "1500", "cbs", "abc")); // 가격과 수량이 숫자가 아닐 때
		detailsCases.add(Arrays.asList("콜라", "99", "10")); // 가격이 100 미만일 때
		detailsCases.add(Arrays.asList("콜라", "111", "10")); // 가격이 10으로 나누어 떨어지지 않을 때
		for (List<String> details : detailsCases) {
			assertThatThrownBy(() -> {
				new Item(details);
			}).isInstanceOf(IllegalArgumentException.class);
		}
	}
}
