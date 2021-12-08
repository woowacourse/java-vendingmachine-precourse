package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {
    public static int generateRandomCoins(List<Integer> coinList) {
        return Randoms.pickNumberInList(coinList);
    }
}
