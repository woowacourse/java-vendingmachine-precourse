package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.model.coin.Coins;
import vendingmachine.model.drink.Drinks;
import vendingmachine.model.user.UserMoney;
import vendingmachine.view.OutputView;

import static vendingmachine.model.coin.RandomCoins.makeRandomCoins;
import static vendingmachine.view.InputView.readDrinks;
import static vendingmachine.view.InputView.readMoney;
import static vendingmachine.view.OutputView.askDrinkFromUsers;
import static vendingmachine.view.OutputView.askMachineTotalMoney;
import static vendingmachine.view.OutputView.askUserInputMoney;
import static vendingmachine.view.OutputView.printVendingMachineCoins;

public class MainController {
//    VendingMachineController vendingMachineController = new VendingMachineController();

    public void run(){
        Coins coins = askTotalMoney();
        showCoins(coins);
        Drinks drinks = askDrinks();
        VendingMachine vendingMachine = new VendingMachine(coins, drinks);
        UserMoney userMoney = askInputAmount();

    }

    private Coins askTotalMoney(){
        while (true){
            try {
                askMachineTotalMoney();
                return new Coins(makeRandomCoins(readMoney()));
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

    private UserMoney askInputAmount() {
        while (true) {
            try {
                askUserInputMoney();
                return new UserMoney(readMoney());
            } catch (IllegalArgumentException exception) {
                OutputView.errorMessage(exception.getMessage());
            }
        }
    }
}
