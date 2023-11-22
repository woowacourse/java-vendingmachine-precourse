package vendingmachine.controller;

import vendingmachine.model.coin.Coins;
import vendingmachine.model.drink.Drinks;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import static vendingmachine.model.coin.RandomCoins.makeRandomCoins;
import static vendingmachine.view.InputView.readDrinks;
import static vendingmachine.view.OutputView.askDrinkFromUsers;
import static vendingmachine.view.OutputView.askMachineTotalMoney;
import static vendingmachine.view.OutputView.printVendingMachineCoins;

public class MainController {
//    VendingMachineController vendingMachineController = new VendingMachineController();

    public void run(){
        Coins coins = askTotalMoney();
        showCoins(coins);
        askDrinks();
    }

    private Coins askTotalMoney(){
        while (true){
            try {
                askMachineTotalMoney();
                return new Coins(makeRandomCoins(InputView.readTotalMoney()));
            } catch (IllegalArgumentException exception) {
                OutputView.errorMessage(exception.getMessage());
            }
        }
    }

    private void showCoins(Coins coins) {
        printVendingMachineCoins(coins.coinsCount());
    }

    private Drinks askDrinks() {
        while (true) {
            try {
                askDrinkFromUsers();
                return new Drinks(readDrinks());
            } catch (IllegalArgumentException exception) {
                OutputView.errorMessage(exception.getMessage());
            }
        }
    }
}
