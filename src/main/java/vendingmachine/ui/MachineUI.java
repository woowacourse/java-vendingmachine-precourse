package vendingmachine.ui;

import java.util.Map;

public interface MachineUI {
    void showAmount();
    void showExchange(Map<String,Integer> exchangedCoins);
}
