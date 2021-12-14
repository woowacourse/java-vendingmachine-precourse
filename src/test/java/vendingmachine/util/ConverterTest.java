package vendingmachine.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import vendingmachine.constant.ErrorConst;
import vendingmachine.domain.Item;

class ConverterTest {

	@Nested
	class ToItem {
		@DisplayName("성공")
		@Test
		void successToItems() {
			String inputText = "[콜라,1000,100];[사이다,300,0]";
			List<Item> items = Converter.toItems(inputText);

			assertEquals(items.get(0).getName(), "콜라");
			assertEquals(items.get(0).getPrice(), 1000);
			assertTrue(items.get(0).isRemain());

			assertEquals(items.get(1).getName(), "사이다");
			assertEquals(items.get(1).getPrice(), 300);
			assertFalse(items.get(1).isRemain());
		}

		@DisplayName("실패 : ;로 스플릿되지 않을 경우")
		@Test
		void failUndefinedSeparator() {
			String inputText = "[콜라,1000,100],[사이다,300,0]";
			IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> Converter.toItems(inputText));
			assertEquals(e.getMessage(), ErrorConst.ITEM_OUT_OF_FORMAT);
		}
	}
}