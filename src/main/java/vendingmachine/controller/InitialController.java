package vendingmachine.controller;

import java.util.List;
import java.util.function.Supplier;
import vendingmachine.Credit;
import vendingmachine.VendingMachine;
import vendingmachine.coin.Coins;
import vendingmachine.coin.generator.CoinGenerator;
import vendingmachine.exception.RetryExceptionHandler;
import vendingmachine.exception.VendingMachineException;
import vendingmachine.menu.Menus;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class InitialController {
    public VendingMachine create(CoinGenerator generator){
        Coins coins = get(() -> makeCoins(generator));
        Menus menus = get(this::makeMenus);
        Credit credit = get(this::getCredit);
        return new VendingMachine(menus, credit, coins);
    }

    private Coins makeCoins(CoinGenerator generator) {
        int coinMoney = getCoinMoney();
        Coins coins = new Coins(generator.getCoins(coinMoney));
        OutputView.printCoins(coins);
        return coins;
    }

    private int getCoinMoney() {
        int coinMoney = InputView.getCoinMoney();
        validateMoney(coinMoney);
        return coinMoney;
    }

    private void validateMoney(int coinMoney) {
        if(coinMoney < 0 || coinMoney % 10 != 0){
            throw VendingMachineException.INVALID_MONEY_VALUE.makeException();
        }
    }

    private Menus makeMenus() {
        List<String> menus = InputView.getMenus();

        return new Menus(menus);
    }

    private Credit getCredit(){
        int initMoney = InputView.getInitMoney();
        return new Credit(initMoney);
    }

    private <T> T get(Supplier<T> supplier){
        return RetryExceptionHandler.get(supplier);
    }
}
