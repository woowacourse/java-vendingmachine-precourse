package vendingmachine.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }
    
    public int getAmount() {
    	return amount;
    }
        
    public static List<Integer> getAmountList(){
    	return Stream.of(Coin.values())
    			.map(Coin::getAmount)
    			.collect(Collectors.toList());
    }
}
