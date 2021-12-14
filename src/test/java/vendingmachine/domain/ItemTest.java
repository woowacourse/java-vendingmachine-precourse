package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemTest {
	@DisplayName("물건 구매 가능 여부")
	@Test
	public void canBuyThisAmount() throws Exception {
		//given
		Item Coke = new Item("콜라", 1500, 3);
		//then
		assertFalse(Coke.canBuy(1000));
		assertTrue(Coke.canBuy(1500));
	}

	@DisplayName("물건 구매 시 재고 감소")
	@Test
	public void sellingItem() throws Exception {
	    //given
		Item Coke = new Item("콜라", 1500, 3);
	    //when
		Coke.sell();
	    Coke.sell();
		Coke.sell();
	    //then
		assertFalse(Coke.isRemain());
	}

}