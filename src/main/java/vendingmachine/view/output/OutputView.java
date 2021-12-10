package vendingmachine.view.output;

import java.util.LinkedHashMap;
import java.util.Set;

import vendingmachine.constant.Output;

public class OutputView {

    public void showCoin(LinkedHashMap<Integer, Integer> coinMap) {
        divisionLine();
        print(Output.VENDING_MACHINE_HAS_COIN_GUIDE_MESSAGE.getText());
        Set<Integer> coins = coinMap.keySet();
        for (Integer coin : coins) {
            print(coin + Output.WON.getText() + Output.DELIMITER.getText() + coinMap.get(coin) + Output.UNIT.getText());
        }
        divisionLine();
    }

    private void divisionLine() {
        System.out.println();
    }

    private void print(String message) {
        System.out.println(message);
    }
}