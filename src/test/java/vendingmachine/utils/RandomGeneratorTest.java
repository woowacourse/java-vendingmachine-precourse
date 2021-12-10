package vendingmachine.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("RandomNumber 클래스")
class RandomGeneratorTest {

	@DisplayName("생성한 난수가 올바른 난수인지 체크")
	@RepeatedTest(value = 20, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
	void getRandomNumber() {
		final RandomGenerator randomGenerator = new RandomGenerator();
		final Integer randomNumber = randomGenerator.getRandomNumber();

		assertTrue(0 <= randomNumber && randomNumber <= 16,
			"생성된 난수의 값이 0~16사이여야 한다");
	}
}
