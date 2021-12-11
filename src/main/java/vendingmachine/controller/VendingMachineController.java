package vendingmachine.controller;

import vendingmachine.domain.PossessionCoins;
import vendingmachine.domain.PossessionCoinsGenerator;
import vendingmachine.domain.PossessionMoney;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final PossessionCoinsGenerator possessionCoinsGenerator;

    public VendingMachineController(PossessionCoinsGenerator possessionCoinsGenerator) {
        this.possessionCoinsGenerator = possessionCoinsGenerator;
    }

    public void run() {
        PossessionMoney possessionMoney = InputView.getPossessionMoney();
        PossessionCoins possessionCoins = possessionCoinsGenerator.generate(possessionMoney);

        OutputView.printPossessionCoins(possessionCoins);
    }
}