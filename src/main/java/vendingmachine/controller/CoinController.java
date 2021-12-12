package vendingmachine.controller;

import vendingmachine.service.CoinService;
import vendingmachine.view.OutputView;

public class CoinController {

    CoinService coinService = new CoinService();
    OutputView outputView = new OutputView();

    public void generate(){
        outputView.printMachineMoney();
        coinService.generate();
        //outputView.printMachineCoin();
    }

}
