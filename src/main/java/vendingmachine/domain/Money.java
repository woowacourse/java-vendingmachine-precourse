package vendingmachine.domain;

public class Money {
  private static final String INVALID_MONEY_ERROR_MESSAGE = "[ERROR] 금액은 0원 이상 입력해야 한다.";
  private static final String MERCHANDISE_PRICE_NOT_DIVIDE_10_COIN_ERROR_MESSAGE = "[ERROR] 입력하는 금액은 10원으로 나누어 떨어져야 한다. ";

  private int money;

  public Money (int money){
    validateMoney(money);
    validateDivideMoneyBy10Coin(money);
    this.money = money;
  }
  
  public int getMoney(){
    return money;
  }

  public void deductMoney(int minusMoney){
    money -= minusMoney;
  }

  public boolean isBigMyMoney(int anotherMoney){
    if (money > anotherMoney){
      return true;
    }
    return false;
  }

  public static void validateMoney(int money){
    if (money <= 0){
      throw new IllegalArgumentException(INVALID_MONEY_ERROR_MESSAGE);
    }
  }
  
  public static void validateDivideMoneyBy10Coin(int merchandisePrice){
    if (merchandisePrice % 10 != 0){
      throw new IllegalArgumentException(MERCHANDISE_PRICE_NOT_DIVIDE_10_COIN_ERROR_MESSAGE);
    }
  }

}
