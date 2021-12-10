package vendingmachine;

import java.util.Arrays;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    private int number = 0;

    Coin(final int amount) {
        this.amount = amount; 
    }
    
    public String getKey() {
        return name();
    }
    
    public int getAmount() {
        return amount;
    }
    
    public int getNumber() {
        return number;
    }
    
    public static Coin findByAmount(int number) {
        return Arrays.stream(values())
             .filter(c -> c.amount == number)
             .findAny()
             .orElse(null);
    }

}
