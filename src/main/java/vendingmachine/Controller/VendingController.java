package vendingmachine.Controller;

import vendingmachine.View.InputView;
import vendingmachine.Model.*;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class VendingController {
    private static InputView inputView;

    public VendingController(InputView inputView){
        this.inputView=inputView;
    }

    public static void start(){
        int balance=getBalance();
        Coins coins=decideCoins(balance);
        VendingMachine vendingMachine=new VendingMachine(balance, coins);

    }
    private static int getBalance(){
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return Integer.parseInt(inputView.getInput());
    }

    private static Coins decideCoins(int balance){
        int coin500Num=getCoinNum(balance, "COIN_500");
        balance-=coin500Num*Coin.valueOf("COIN_500").getAmount();
        int coin100Num=getCoinNum(balance, "COIN_100");
        balance-=coin100Num*Coin.valueOf("COIN_100").getAmount();
        int coin50Num=getCoinNum(balance, "COIN_50");
        balance-=coin50Num*Coin.valueOf("COIN_50").getAmount();
        int coin10Num=getCoinNum(balance, "COIN_10");
        return new Coins(coin500Num, coin100Num, coin50Num, coin10Num);
    }
    private static int getCoinNum(int balance, String coin){
        return Randoms.pickNumberInRange(0,balance/Coin.valueOf(coin).getAmount());
    }
}
