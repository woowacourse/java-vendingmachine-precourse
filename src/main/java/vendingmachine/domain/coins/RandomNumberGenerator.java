package vendingmachine.domain.coins;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;


public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate(List<Integer> numbers) {
        return Randoms.pickNumberInList(numbers);
    }
}
