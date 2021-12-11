package vendingmachine;

import java.util.ArrayList;

public class Machine {
    private int money;
    private ArrayList<Product> products;
    //private Coin coins;

    Machine() {
        Coin.makeRandom(InputView.inputMachineMoney());
        OutputView.printMachineCoin();
        this.products = InputView.inputProductList();
        this.money = InputView.inputMoney();
        while (true) {
            InputView.inputProduct();
        }
    }
}
