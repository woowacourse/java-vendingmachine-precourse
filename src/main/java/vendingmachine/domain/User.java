package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
  private final Money userMoney;
  private final List<Merchandise> buyingMerchandiseList;

  public User(int userMoney){
    this.userMoney = new Money(userMoney);
    buyingMerchandiseList = new ArrayList<>();
  }

  public int getUserMoney() {
    return userMoney.getMoney();
    
  }
  
  public void buyMerchandise(Merchandise buyingMerchandise) {
    buyingMerchandiseList.add(buyingMerchandise);
    userMoney.deductMoney(buyingMerchandise.getMerchandiseMoney());
    
  }
  
  
  
}
