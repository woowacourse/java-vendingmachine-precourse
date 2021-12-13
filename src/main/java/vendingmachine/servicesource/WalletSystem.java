package vendingmachine.servicesource;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.utils.moneychecker.InsertMoneyChecker;

import java.util.*;

public class WalletSystem {
    private int systemBalance;
    private int insertedBalance;
    private final WalletPrinter walletPrinter;
    private HashMap<Coin, Integer> remainCoinsMap = new HashMap<>();
    private HashMap<Integer, Coin> amountToCoinMap = new HashMap<>();

    public WalletSystem(int systemBalance){
        this.systemBalance = systemBalance;
        setCoinHashMap();
        exchangeBalanceToRandomCoins();

        walletPrinter = new WalletPrinter(this);
        walletPrinter.printAllCoins();
    }

    private void setCoinHashMap(){
        Coin[] coins = Coin.values();

        for(Coin coinType : coins){
            remainCoinsMap.put(coinType, 0);
            amountToCoinMap.put(coinType.getAmount(), coinType);
        }

    }

    private void exchangeBalanceToRandomCoins(){

        while(systemBalance > 0){
            List<Integer> amountOfCoins = Coin.getAmountsListLowerThanBalance(systemBalance);
            int selectedCoinAmount = Randoms.pickNumberInList(amountOfCoins);
            Coin selectedCoin = amountToCoinMap.get(selectedCoinAmount);

            systemBalance -= selectedCoinAmount;
            remainCoinsMap.replace( selectedCoin, remainCoinsMap.get(selectedCoin) + 1);
        }

    }

    void withdrawInsertedBalance(int price){
        insertedBalance -= price;
    }

    boolean haveEnoughInsertedBalanceToPurchase(int cheapestPrice){
        boolean canPurchase =true;

        if(insertedBalance < cheapestPrice ){
            canPurchase = false;
            walletPrinter.printNotEnoughBalance();
        }

        return canPurchase;
    }

    boolean canBuySelectedProduct(Product product){
        boolean canBuy = true;

        try{
            checkRemainBalance(product.getPrice());
        }catch(IllegalArgumentException exception){
            canBuy = false;
            System.out.println(exception.getMessage());
        }

        return canBuy;
    }

    void returnChangeByRemainCoins(){
        Coin[] coinTypes = Coin.getSortedCoinTypes();
        HashMap<Coin, Integer> returnCoinsMap = new HashMap<>();

        for(Coin currentCoinType : coinTypes){
            int returnCoinNumber = getMaxReturnCoinNumber(currentCoinType);
            returnCoinsMap.put(currentCoinType, returnCoinNumber);

            remainCoinsMap.replace(currentCoinType, remainCoinsMap.get(currentCoinType) - returnCoinNumber);
            insertedBalance -= currentCoinType.getAmount() * returnCoinNumber;
        }

        walletPrinter.printReturnedCoins(returnCoinsMap);
    }

    private int getMaxReturnCoinNumber(Coin coinType){
        int needCoinNumber = insertedBalance / coinType.getAmount();
        int remainCoinNumber = remainCoinsMap.get(coinType);

        if(needCoinNumber >= remainCoinNumber){
            return remainCoinNumber;
        }

        return needCoinNumber;
    }

    private void checkRemainBalance(int price){

        if(insertedBalance < price ){
            throw new IllegalArgumentException("[ERROR]: 잔액이 부족합니다.");
        }

    }

    WalletPrinter getWalletPrinter(){
        return walletPrinter;
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

}
