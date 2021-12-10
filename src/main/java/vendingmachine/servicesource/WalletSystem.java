package vendingmachine.servicesource;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WalletSystem {
    private int balance;
    private HashMap<Coin, Integer> remainCoins = new HashMap<Coin, Integer>();

    List<Integer> list = new ArrayList<>();

    public WalletSystem(int balance){
        this.balance = balance;

        exchangeBalanceToRandomCoins();
    }

    private void exchangeBalanceToRandomCoins(){
        Coin[] coinTypes =  Coin.values();

        for(Coin currentCoin : coinTypes){
            int maxNumber = balance / currentCoin.getAmount();
            int pickedNumber = Randoms.pickNumberInList(getRandomNumberList(maxNumber));
            balance -= currentCoin.getAmount() * pickedNumber;
            remainCoins.put(currentCoin,pickedNumber);
            System.out.println(currentCoin.getAmount() + " : " + pickedNumber);
        }

    }

    private List<Integer> getRandomNumberList(int maxNumber){
        List<Integer> numberList = new ArrayList<>();

        for(int i=0; i<=maxNumber ; ++i){
            numberList.add(i);
        }

        return numberList;
    }

    public int getRemainCoins(Coin coinType) {
        return remainCoins.get(coinType);
    }
}
