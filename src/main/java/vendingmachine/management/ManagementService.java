package vendingmachine.management;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;

public class ManagementService {

    public static void generateCoins(int deposit) {
        List<Integer> coinAmounts = Stream.of(Coin.values()).map(a -> a.getAmount()).collect(Collectors.toList());
        
        while(deposit >= 0) {    
            int tmp = Randoms.pickNumberInList(coinAmounts);
            
            if(deposit - tmp < 0) {
                continue;
            }
            
            deposit -= tmp;
            Coin coinType = Coin.findByAmount(tmp);
            Coin.addNumber(coinType);
        }
    }
}
