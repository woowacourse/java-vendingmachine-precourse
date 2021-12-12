package vendingmachine.service;

import vendingmachine.CoinInventory;
import vendingmachine.view.InputView;

public class CoinService {
    InputView inputView = new InputView();

    public void generate(){
      int money = Integer.parseInt(inputView.getMoney());
      System.out.println("받은 돈: "+money);
      //exchangeMoneyToCoin();
    }

}
