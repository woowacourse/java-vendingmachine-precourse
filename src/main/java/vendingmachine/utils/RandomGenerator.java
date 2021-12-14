package vendingmachine.utils;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * <h1>난수를 생성한다</h1>
 * 자판지 안에 있는 코인 갯수를 정하기 위해
 * 필요한 난수를 생성한다
 *
 * @author yunki kim
 * @version 1.0
 * @since 2021-12-10(V1.0)
 */

public class RandomGenerator {

	private static final Integer RANDOM_NUMBER_MIN_RANGE = 1;

	private static final Integer RANDOM_NUMBER_MAX_RANGE = 9;

	private final List<Integer> numbers;

	public RandomGenerator() {
		super();
		numbers = new ArrayList<>();
		for(int number = RANDOM_NUMBER_MIN_RANGE; number < RANDOM_NUMBER_MAX_RANGE; number++) {
			numbers.add(number);
		}
	}

	public Integer getRandomNumber() {
		return Randoms.pickNumberInList(numbers);
	}
}
