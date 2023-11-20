package vendingmachine.utils;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.List;
import org.junit.jupiter.api.Test;

class CoinGeneratorTest {

    @Test
    void pickNumberInList는_주어진동전금액에서_무작위로_하나의동전을선택한다() {
        int result = pickNumberInList(List.of(500, 100, 50, 10));
        System.out.println(result);
    }

}