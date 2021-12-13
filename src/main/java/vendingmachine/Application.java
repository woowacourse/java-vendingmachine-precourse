package vendingmachine;

import userInterface.CoinListManager;
import userInterface.OrderManager;
import userInterface.ProductListManager;
import userInterface.DepositManager;

public class Application {
    public static void main(String[] args) {
        /* TODO : 프로그램 구현
         * 6. 잔여 금액 반환(출력)
         */
        Coins coinList = new Coins();
        CoinListManager coinListManager = new CoinListManager(coinList);
        coinListManager.makeRandomList();
        coinListManager.printCoinList();
        Products productList = new ProductListManager().getList();
        DepositManager depositManager = new DepositManager();
        OrderManager orderManager = new OrderManager(productList, depositManager);
        orderManager.run();
        depositManager.printDeposit();
        coinListManager.returnChange(depositManager.getDeposit());
    }
}
