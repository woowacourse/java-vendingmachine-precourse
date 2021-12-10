package vendingmachine.domain.coin.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class CoinRandomProvider implements CoinProvider {
    @Override
    public int drawCoinLessThanBalance(int balance) {
        while (true) {
            int num = Randoms.pickNumberInList(Arrays.asList(10, 50, 100, 500));
            if (num <= balance)
                return num;
        }
    }
}
