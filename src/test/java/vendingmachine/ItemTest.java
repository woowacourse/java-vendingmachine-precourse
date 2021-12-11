package vendingmachine;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ItemTest {

	// @Test
	// @DisplayName("상품명 검증")
	// void validNameTest() {
	// 	String nameInput1 = "콜라";
	// 	String nameInput2 = "";
	// 	assertThat(Item.validName(nameInput1)).isTrue();
	// 	assertThat(Item.validName(nameInput2)).isFalse();
	// }

	// @Test
	// @DisplayName("가격 검증")
	// void validPriceTest() {
	// 	int testPrice1 = 1210;
	// 	int testPrice2 = 1211;
	// 	int testPrice3 = 0;
	// 	int testPrice4 = -10;
	// 	assertThat(Item.validPrice(testPrice1)).isTrue();
	// 	assertThat(Item.validPrice(testPrice2)).isFalse();
	// 	assertThat(Item.validPrice(testPrice3)).isFalse();
	// 	assertThat(Item.validPrice(testPrice4)).isFalse();
	// }

	// @Test
	// @DisplayName("수량 검증")
	// void validCountTest() {
	// 	int testCount1 = 0;
	// 	int testCount2 = -1;
	// 	int testCount3 = 1;
	// 	assertThat(Item.validCount(testCount1)).isFalse();
	// 	assertThat(Item.validCount(testCount2)).isFalse();
	// 	assertThat(Item.validCount(testCount3)).isTrue();
	// }

	// @Test
	// @DisplayName("잘못된 아이템 입력 검증")
	// void validItemStatusTest() {
	// 	String name = "a";
	// 	int price = 31;
	// 	int count = 3;
	// 	assertThat(Item.validItemStatus(name, price, count)).isFalse();
	// }
	//
	// @Test
	// @DisplayName("상태 얻기 테스트")
	// void getStatusTest() {
	// 	Item item = new Item("콜라", 1000, 10);
	// 	assertThat(item.getStatus()).startsWith("콜라");
	// }
}
