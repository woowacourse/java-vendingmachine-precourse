package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

	@Test
	@DisplayName("문자열로 이름을 생성한다.")
	public void testCreateName() {
	    // given
		String input = "someName";
	    // when
		Name name = new Name(input);
	    // then
		assertEquals("someName", name.toString());
	}

	@Test
	@DisplayName("이름이 같으면 같은 객체로 취급한다.")
	public void testEqualsNames() {
	    // given
		String inputA = "someName";
		String inputB = "someName";
	    // when
		Name nameA = new Name(inputA);
		Name nameB = new Name(inputB);
	    // then
		assertEquals(nameA, nameB);
	}
}