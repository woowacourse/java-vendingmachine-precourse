package vendingmachine.domain.coin.provider;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class CoinRandomProvider implements CoinProvider {
    @Override
    public int drawCoinLessThanBalance(int machineBalance) {
        while (true) {
            int randomNum = Randoms.pickNumberInList(Arrays.asList(10, 50, 100, 500));
            if (randomNum <= machineBalance)
                return randomNum;
        }
    }
}
