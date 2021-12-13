package vendingmachine.management;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

import vendingmachine.Coin;
import vendingmachine.management.validation.CheckCommodityFormat;
import vendingmachine.management.validation.CheckCommodityPrice;
import vendingmachine.management.validation.CheckCommodityQuantity;

public class ManagementService {
    private static final int COMMODITY_NAME = 0;
    private static final int COMMODITY_PRICE = 1;
    private static final int COMMODITY_QUANTITY = 2;
    
    public static void generateCoins(int deposit) {
        List<Integer> coinAmounts = Stream.of(Coin.values()).map(a -> a.getAmount()).collect(Collectors.toList());
        
        while(deposit > 0) {    
            int tmp = Randoms.pickNumberInList(coinAmounts);
            
            if(deposit - tmp < 0) {
                continue;
            }
            
            deposit -= tmp;
            Coin coinType = Coin.findByAmount(tmp);
            Coin.addNumber(coinType);
        }
    }
    
    public static void addCommodityInList(Commodity commodity) {
        CommodityRepository.addCommodity(commodity);
    }
    
    public static Commodity toCommodity(String input) {
        CheckCommodityFormat.validationSquareBracket(input);
        input = input.substring(1,input.length()-1);
        String [] components = input.split(",");
        String name = components[COMMODITY_NAME];
        CheckCommodityPrice.validationFigure(components[COMMODITY_PRICE]);
        int price = Integer.parseInt(components[COMMODITY_PRICE]);
        CheckCommodityQuantity.validationFigure(components[COMMODITY_QUANTITY]);
        int quantity = Integer.parseInt(components[COMMODITY_QUANTITY]);
        
        return new Commodity(name,price,quantity);
    }   
}
