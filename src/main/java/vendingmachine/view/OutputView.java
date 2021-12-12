package vendingmachine.view;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.model.Coin;
import vendingmachine.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void askVendingMachinePrice(){
        System.out.println(Constant.VENDING_MACHINE_HOLDING_PRICE);
    }

    public static void showCoins(int vendingmachineholdingPrice){
        getCoins(vendingmachineholdingPrice);
        for(Coin coins : Coin.values()){
            System.out.println(coins.getAmount()+"원 - "+ coins.getNum()+"개");
        }
    }

    private static void getCoins(int vendingmachineholdingPrice){
        int remainMoney = vendingmachineholdingPrice;
        for(Coin coins : Coin.values()) {
            if (coins.getAmount() == 10) {coins.setNum(remainMoney / 10);
                break;
            }
            int maxNumCoin = remainMoney / coins.getAmount();
            List<Integer> NumCoinList = new ArrayList<>();
            for (int i = 0; i < maxNumCoin + 1; i++) {NumCoinList.add(i);}
            int numCoin = Randoms.pickNumberInList(NumCoinList);
            remainMoney -= numCoin * coins.getAmount();
            coins.setNum(numCoin);
        }
    }
}
