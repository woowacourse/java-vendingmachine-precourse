package vendingmachine.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RandomNumber 클래스")
class RandomGeneratorTest {

	@DisplayName("생성한 난수가 올바른 난수인지 체크")
	@Test
	void getRandomNumber() {
		final RandomGenerator randomGenerator = new RandomGenerator();
		final Integer randomNumber = randomGenerator.getRandomNumber();

		assertTrue(1 <= randomNumber && randomNumber <= 9,
			"생성된 난수의 값이 1~randomNumberMaxRange 사이여야 한다");
	}
}
