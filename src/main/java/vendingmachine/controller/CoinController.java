package vendingmachine.controller;

import vendingmachine.service.CoinService;
import vendingmachine.view.OutputView;

public class CoinController {

    CoinService coinService = new CoinService();

    public void generate() {
        OutputView.printMachineMoney();
        coinService.generate();
        OutputView.printCoin();
    }
}
