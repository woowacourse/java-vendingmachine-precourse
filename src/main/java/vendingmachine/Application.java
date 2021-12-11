package vendingmachine;

import inputcontroller.InputGenerator;

import static models.Product.totalRemains;
import static vendingmachine.VendingMachineMain.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        makeInitialCoins();
        makeInitialProducts();

        InputGenerator.inputUserMoney();
        while (true) {
            buy();
            if (userInputMoney < minCost || totalRemains == 0) {
                int[] numOfCoin = makeChange();
                VendingMachineUI.printChange(numOfCoin);
                break;
            }
        }
    }
}