package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import vendingmachine.constant.ErrorConst;

class ItemListTest {

	@DisplayName("ItemList 생성")
	@Nested
	class InitItemList {
		@DisplayName("정상적인 ItemList 생성")
		@Test
		public void successNewItemList() throws Exception {
			//given
			List<Item> testItemList = Arrays.asList(
				new Item("콜라", 3000, 10),
				new Item("사이다", 3000, 10)
			);
			//then
			assertDoesNotThrow(() -> new ItemList(testItemList));
		}

		@DisplayName("실패 : 중복된 이름의 ItemList")
		@Test
		public void failCheckDupName() throws Exception {
			//given
			List<Item> testItemList = Arrays.asList(
				new Item("콜라", 3000, 10),
				new Item("콜라", 3000, 10)
			);
			//then
			IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> new ItemList(testItemList));

			assertEquals(exception.getMessage(), ErrorConst.DUP_ITEM_NAME);
		}

	}

	@DisplayName("구입 가능한 상품이 있는지 확인")
	@Nested
	class HaveAffordableItem {
		@DisplayName("구매 가능한 상품이 있는 경우")
		@Test
		public void trueHaveAffordableItem() throws Exception {
			//given
			List<Item> pureItemList = Arrays.asList(
				new Item("콜라", 1000, 3),
				new Item("사이다", 3000, 5)
			);

			ItemList itemList = new ItemList(pureItemList);
			//then
			boolean haveAffordableItem = itemList.haveAffordableItem(1000);
			assertTrue(haveAffordableItem);
		}

		@DisplayName("가격은 구매 가능하지만 재고가 없는 경우")
		@Test
		public void falseNoStock() throws Exception {
			//given
			List<Item> pureItemList = Arrays.asList(
				new Item("콜라", 1000, 0),
				new Item("사이다", 6000, 1)
			);
			ItemList itemList = new ItemList(pureItemList);
			//then
			assertFalse(itemList.haveAffordableItem(5000));
		}

		@DisplayName("가격이 높아 구매하지 못하는 경우")
		@Test
		public void falseNoSufficientMoney() throws Exception {
			//given
			List<Item> pureItemList = Arrays.asList(
				new Item("콜라", 1000, 3),
				new Item("사이다", 3000, 4)
			);
			ItemList itemList = new ItemList(pureItemList);
			//then
			assertFalse(itemList.haveAffordableItem(500));
		}
	}

	@DisplayName("해당 이름의 아이템 획득")
	@Nested
	class GetItem {
		@DisplayName("성공")
		@Test
		public void successGetItem() throws Exception {
			//given
			List<Item> pureItemList = Arrays.asList(
				new Item("콜라", 1000, 3)
			);
			ItemList itemList = new ItemList(pureItemList);
			//when
			Item item = itemList.getItem("콜라");
			//then
			assertEquals(item.getName(), "콜라");
			assertEquals(item.getPrice(), 1000);
			assertTrue(item.isRemain());
		}

		@DisplayName("실패 : 해당 이름의 상품이 존재하지 않을 경우")
		@Test
		public void failNoThisName() throws Exception {
		    //given
			List<Item> pureItemList = Arrays.asList(
				new Item("콜라", 1000, 3),
				new Item("사이다", 1500, 10)
			);
			ItemList itemList = new ItemList(pureItemList);
		    //when
			IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
				() -> itemList.getItem("환타"));
			//then
			assertEquals(exception.getMessage(), ErrorConst.HAVE_NO_THIS_ITEM);
		}
	}
}