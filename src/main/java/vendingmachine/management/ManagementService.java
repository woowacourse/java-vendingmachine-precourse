package vendingmachine.management;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;
import vendingmachine.management.validation.CheckCommodityFormat;
import vendingmachine.management.validation.CheckCommodityName;
import vendingmachine.management.validation.CheckCommodityPrice;
import vendingmachine.management.validation.CheckCommodityQuantity;

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
    
    public static Commodity toCommodity(String input) {
        String [] components = input.split(",");
        
        return new Commodity(components[0],Integer.parseInt(components[1]),Integer.parseInt(components[2]));
    }   
}
