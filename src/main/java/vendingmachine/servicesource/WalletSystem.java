package vendingmachine.servicesource;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.utils.moneychecker.InsertMoneyChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WalletSystem {
    private int systemBalance;
    private int insertedBalance;
    private final WalletPrinter walletPrinter;
    private HashMap<Coin, Integer> remainCoinsMap = new HashMap<Coin, Integer>();

    public WalletSystem(int systemBalance){
        this.systemBalance = systemBalance;
        exchangeBalanceToRandomCoins();

        walletPrinter = new WalletPrinter(this);
        walletPrinter.printAllCoins();
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

    int getRemainCoinsByCoinType(Coin coinType) {
        return remainCoinsMap.get(coinType);
    }

    void setInsertedBalance(){
        insertedBalance = InsertMoneyChecker.getInsertMoney();
    }

    int getInsertedBalance(){
        return insertedBalance;
    }

    WalletPrinter getWalletPrinter(){
        return walletPrinter;
    }
}
