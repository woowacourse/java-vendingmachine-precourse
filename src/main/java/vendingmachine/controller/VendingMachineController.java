package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinMaker;
import vendingmachine.view.Input;

import java.util.Map;

public class VendingMachineController {

    private final Input input = new Input();
    private final CoinMaker coinMaker = new CoinMaker();

    public void run() {
        Map<Coin, Integer> coins = coinMaker.make(input.readAmount());
    }
}
