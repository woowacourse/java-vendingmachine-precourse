package vendingmachine.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    public static int generate(List<Integer> numbers) {
        return Randoms.pickNumberInList(numbers);
    }
}
