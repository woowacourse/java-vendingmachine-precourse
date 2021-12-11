package vendingmachine;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Machine {
    public NumberManager numberManager = new NumberManager();

    private CoinMap coinMap=new CoinMap();
    private final List<Integer> amountList= new ArrayList<>(Arrays.asList(500,100,50,10));
    public ProductMap productMap = new ProductMap();
    public int userAmount = 0;

    public Machine() {
    }

    public void setCoinsInMachine() {
        int heldAmount = getHeldAmountInMachine();
        makeCoins(heldAmount);
    }

    private int getHeldAmountInMachine() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        while (true) {
            String heldAmountString = readLine();
            try {
                int heldAmount = numberManager.toNumber(heldAmountString, NumberManager.TYPE_AMOUNT);
                return heldAmount;
            } catch (IllegalArgumentException e) {}
        }
    }

    private void makeCoins(int amount){
        coinMap.makeCoins(amount);
        coinMap.printCoins(coinMap.ALL_PRINT);
    }

    public void setProductMap() {
        while (true) {
            String productListString;
            try {
                productListString = readLine();
                productMap.toProductMap(productListString);
                return;
            } catch (IllegalArgumentException e) {}
        }
    }

}
