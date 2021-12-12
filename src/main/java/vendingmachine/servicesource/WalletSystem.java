package vendingmachine.servicesource;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.utils.moneychecker.InsertMoneyChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WalletSystem {
    private int systemBalance;
    private int insertedBalance;
    private final WalletUI ui;
    private HashMap<Coin, Integer> remainCoinsMap = new HashMap<Coin, Integer>();

    public WalletSystem(int systemBalance){
        this.systemBalance = systemBalance;
        exchangeBalanceToRandomCoins();

        ui = new WalletUI(this);
        ui.printRemainCoins();
    }

    private void exchangeBalanceToRandomCoins(){
        Coin[] coinTypes =  Coin.values();

        for(Coin currentCoin : coinTypes){
            int maxNumber = systemBalance / currentCoin.getAmount();
            int pickedNumber = Randoms.pickNumberInList(getRandomNumberList(maxNumber));
            systemBalance -= currentCoin.getAmount() * pickedNumber;
            remainCoinsMap.put(currentCoin,pickedNumber);
        }

    }

    private List<Integer> getRandomNumberList(int maxNumber){
        List<Integer> numberList = new ArrayList<>();

        for(int i=0; i<=maxNumber ; ++i){
            numberList.add(i);
        }

        return numberList;
    }

    public int getRemainCoinsByCoinType(Coin coinType) {
        return remainCoinsMap.get(coinType);
    }

    public void setInsertedBalance(){
        insertedBalance = InsertMoneyChecker.getInsertMoney();
    }

    public int getInsertedBalance(){
        return insertedBalance;
    }
}
