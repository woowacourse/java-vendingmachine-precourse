package vendingmachine.utils;

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

	private static final Integer RANDOM_NUMBER_MIN_RANGE = 0;

	private static final Integer RANDOM_NUMBER_MAX_RANGE = 16;

	public RandomGenerator() {
		super();
	}

	public Integer getRandomNumber() {
		return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_RANGE,
			RANDOM_NUMBER_MAX_RANGE);
	}
}
