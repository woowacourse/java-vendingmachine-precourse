package vendingmachine;

import userInterface.CoinListManager;
import userInterface.ProductListManager;
import userInterface.DepositManager;

public class Application {
    public static void main(String[] args) {
        /* TODO : 프로그램 구현
         * 5. 자판기 돌리기 (남은금액 계산 -> 주문받기(에러체크->반복) -> 잔고 출력)
         * 6. 잔여 금액 반환(출력)
         */
        Coins coinList = new Coins();
        CoinListManager coinListManager = new CoinListManager(coinList);
        coinListManager.makeRandomList();
        coinListManager.printCoinList();
        Products productList = new ProductListManager().getList();
        DepositManager depositManager = new DepositManager();
        depositManager.printDeposit();
    }
}
