package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;
import controller.VendingMachineController;
import model.Coin;
import model.CoinGenerator;
import model.Product;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachineController vendingMachineController = new VendingMachineController();
        vendingMachineController.start();


    }
}
