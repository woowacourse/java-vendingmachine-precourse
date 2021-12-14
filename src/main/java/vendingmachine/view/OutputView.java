package vendingmachine.view;

import java.util.LinkedHashMap;
import java.util.Set;

import vendingmachine.constant.Condition;
import vendingmachine.constant.Output;
import vendingmachine.domain.Money;
import vendingmachine.domain.ChangeCoin;

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

    public void showChange(LinkedHashMap<Integer, Integer> coinMap) {
        divisionLine();
        print(Output.PURCHASE_MONEY.getText() + Money.getInstance().getMoney());
        LinkedHashMap<Integer, Integer> changeCoinMap =
                ChangeCoin.getInstance().calcReturnChangeToCoin(coinMap);

        if (changeCoinMap.size() > Condition.QUANTITY_0.getNumber()) {
            print(Output.CHANGE.getText());
            for (Integer coin : changeCoinMap.keySet()) {
                print(coin + Output.WON.getText()+ Output.DELIMITER.getText() + changeCoinMap.get(coin) + Output.UNIT.getText());
            }
        }
    }
}