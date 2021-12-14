package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        
        // 동전 목록
        List<Integer> coins = Coin.getCoinList();
        // 자판기의 돈 입력
        Vendingmachine vendingmachine = new Vendingmachine();
        vendingmachine.inputVendMoney();
        Integer inputmoney = vendingmachine.getVendMoney();

        // 자판기의 돈을 동전으로 바꿈
        vendingmachine.getVendMoneyToCoin();
        vendingmachine.printRandomCoin();

//        int[] randomList = Utils.generateRandomCoin(coins,inputmoney);
//        Utils.printRandomCoin(coins, randomList);

        // 상품 입력
        vendingmachine.prodInput();
        
        // 사용자의 돈 입력
        vendingmachine.userMoneyInput();


        // 구매
//        int restMoney = Utils.play(productList, userMoney);
        int restMoney = vendingmachine.play();
//        Utils.printLastMoney(inputmoney, restMoney, coins, randomList);
        vendingmachine.printLastMoney();
    }
}
