package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MachineMoney {

    private MachineMoney(int machineMoney) {
    }

    public static MachineMoney from(int machineMoney) {

        List<Integer> coin = Arrays.stream(Coin.values())
                .map(value -> value.getAmount())
                .collect(Collectors.toList());

        while (machineMoney > 0) {
            int newCoin = Randoms.pickNumberInList(coin);
            System.out.println(newCoin);
            machineMoney -= newCoin;
        }

        return new MachineMoney(machineMoney);
    }


}
