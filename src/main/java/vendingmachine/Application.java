package vendingmachine;

import inputcontroller.InputGenerator;

import static vendingmachine.VendingMachineMain.*;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        makeInitialCoins();
        makeInitialProducts();

        InputGenerator.inputUserMoney();
        while (true) {
            giveAnOrder();
            if (!canBuy()) {
                int[] numOfCoin = makeChange();
                VendingMachineUI.printChange(numOfCoin);
                break;
            }
        }
    }

    public static boolean canBuy() {
        if (userInputMoney < minCost) {
            return false;
        }

        boolean ret = false;
        for (String name: name2Product.keySet()) {
            if (!name2Product.get(name).isSoldOut() && name2Product.get(name).value() <= userInputMoney) {
                ret = true;
                break;
            }
        }

        return ret;
    }
}