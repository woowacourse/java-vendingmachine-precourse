package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.model.coin.Coins;
import vendingmachine.model.drink.Drinks;
import vendingmachine.model.user.UserMoney;
import vendingmachine.view.OutputView;

import static vendingmachine.model.coin.RandomCoins.makeRandomCoins;
import static vendingmachine.view.InputView.readDrinks;
import static vendingmachine.view.InputView.readMoney;
import static vendingmachine.view.InputView.readPurchase;
import static vendingmachine.view.OutputView.askDrinkFromUsers;
import static vendingmachine.view.OutputView.askMachineTotalMoney;
import static vendingmachine.view.OutputView.askPurchaseDrinkType;
import static vendingmachine.view.OutputView.askUserInputMoney;
import static vendingmachine.view.OutputView.printVendingMachineCoins;
import static vendingmachine.view.OutputView.println;
import static vendingmachine.view.OutputView.showBalance;

public class MainController {
//    VendingMachineController vendingMachineController = new VendingMachineController();

    public void run(){
        Coins coins = askTotalMoney();
        showCoins(coins);
        Drinks drinks = askDrinks();
        VendingMachine vendingMachine = new VendingMachine(coins, drinks);
        UserMoney userMoney = askInputAmount();

        makePurchase(vendingMachine, userMoney);
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

    private void makePurchase(VendingMachine vendingMachine, UserMoney userMoney) {
        while (vendingMachine.hasMoneyMoreThenMinimumPrice(userMoney)) {
            showBalance(userMoney.getBalance());
            String purchaseDrinkType = askPurchase();
            userMoney.purchaseDrink(vendingMachine.getPrice(purchaseDrinkType));
            println();
        }
        showBalance(userMoney.getBalance());
    }

    private String askPurchase() {
        while (true) {
            try {
                askPurchaseDrinkType();
                return readPurchase();
            } catch (IllegalArgumentException exception) {
                OutputView.errorMessage(exception.getMessage());
            }
        }
    }
}
