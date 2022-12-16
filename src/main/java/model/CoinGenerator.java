package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class CoinGenerator {


    public static void generate(int money){
        while(money!=0){
            int pickedCoin = pickCoin();
            if(money<pickedCoin){
                continue;
            }
            Coin.addCoinNum(pickedCoin);
            money -= pickedCoin;
        }
    }


    public static int pickCoin(){
        return Randoms.pickNumberInList(Arrays.asList(500, 100, 50, 10));
    }
}
