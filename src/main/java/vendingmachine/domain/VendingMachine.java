package vendingmachine.domain;

import java.util.LinkedHashMap;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class VendingMachine {
  private final Money vendingMachineMoney;
  private Merchandises merchandises;
  private final LinkedHashMap<Coin, Integer> coinCounts;
  private final LinkedHashMap<Coin, Integer> returnCoinCounts;

  public VendingMachine(int vendingMachineMoney){
    this.vendingMachineMoney = new Money(vendingMachineMoney);
    coinCounts = new LinkedHashMap<>();
    initCoinCounts(coinCounts);
    returnCoinCounts = new LinkedHashMap<>();
    initCoinCounts(returnCoinCounts);
  }

  public boolean isUserBuyMerchandise(int userMoney) {
    List<Merchandise> notBuyMerchandise = merchandises.selectExpensiveMerchandise(userMoney);
    return notBuyMerchandise.size() != merchandises.getMerchandisesSize();
    
  }

  public boolean isSoldOutMerchandises() {
    return merchandises.isAllMerchandiseSoldOut();
    
  }

  public Merchandise sellMerchandise(String merchandiseName) {
    return merchandises.selectMerchandise(merchandiseName);
    
  }

  public void initCoinCounts(LinkedHashMap<Coin, Integer> coinMap) {
    for (Coin coin : Coin.values()){
      coinMap.put(coin, 0);
    }
    
  }

  public void plusCoin(Coin coin){
    coinCounts.put(coin, coinCounts.get(coin)+1);
  }  

  public void updateReturnCoinMap(LinkedHashMap<Coin, Integer> coinMap, Coin coin, int changeCount) {
    coinMap.put(coin, changeCount);
    
  }

  public void stockMerchandises(Merchandises merchandises) {
    this.merchandises = merchandises;
    
  }

  public LinkedHashMap<Coin, Integer> saveCoinStatus() {
    int tempMoney = vendingMachineMoney.getMoney();
    while(tempMoney != 0){
      int randomCoinValue = Randoms.pickNumberInList(Coin.generateCoinAmountList());
      if (randomCoinValue > tempMoney) {
        continue;
      }
      tempMoney -= randomCoinValue;
      plusCoin(Coin.findCoinByAmount(randomCoinValue));
    }

    return coinCounts;
    
  }

  
}
