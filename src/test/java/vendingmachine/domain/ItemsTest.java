package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.controller.ItemController;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ItemsTest {
	ItemController itemController = new ItemController(new InputView(), new OutputView());

	@DisplayName("이름이 중복되는 상품이 없는 경우 Items 객체를 생성한다")
	@Test
	public void createItems() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(Arrays.asList("콜라", "1500", "10")));
		items.add(new Item(Arrays.asList("사이다", "1000", "19")));
		assertThatCode(() -> new Items(items))
			.doesNotThrowAnyException();
	}

	@DisplayName("이름이 중복되는 상품이 있는 경우 예외를 발생시킨다")
	@Test
	void createItemsException() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(Arrays.asList("콜라", "1500", "10")));
		items.add(new Item(Arrays.asList("사이다", "1000", "19")));
		items.add(new Item(Arrays.asList("콜라", "2000", "20")));
		assertThatThrownBy(() -> {
			new Items(items);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	/* 투입 금액이 상품 가격보다 많으면서 상품명이 존재할 때 */
	@DisplayName("구매가 가능한 상품인 경우 Item 객체를 반환한다")
	@Test
	public void checkItemSellable() {
		assertThatCode(() -> itemController.checkItemSellable(new Item(Arrays.asList("콜라", "1500", "10")), 3000))
			.doesNotThrowAnyException();
	}

	/* 1. 투입 금액이 상품 가격보다 적을 때
	 * 2. 상품의 재고가 소진되었을 때
	 * 3. 상품명이 존재하지 않을 때
	 * */
	@DisplayName("구매가 가능한 상품이 아닌 경우 예외를 발생시킨다")
	@Test
	void findItemByNameException() {
		List<Item> items = Arrays.asList(new Item(Arrays.asList("콜라", "1500", "10")),
			new Item(Arrays.asList("사이다", "1000", "0")));
		for (Item item : items) {
			assertThatThrownBy(() -> {
				itemController.checkItemSellable(item, 1000);
			}).isInstanceOf(IllegalArgumentException.class);
		}
	}
}
