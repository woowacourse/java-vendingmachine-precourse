package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class MachineCoin {
    Map<Coin, Integer> machineCoin = new HashMap<>();

    public void initSetting(){
        for(Coin coin : Coin.values()){
            machineCoin.put(coin, 0);
        }
    }

    public void CreateRandomCoin(int sumCoin){
        initSetting();
        while(sumCoin !=0){
            int randomAmount = Randoms.pickNumberInList(Coin.getCoinList());
            if(sumCoin >= randomAmount){
                sumCoin -= randomAmount;
                Coin randomCoin = Coin.getCoin(randomAmount);
                machineCoin.put(randomCoin, machineCoin.get(randomCoin)+1);
            }
        }
    }
}
