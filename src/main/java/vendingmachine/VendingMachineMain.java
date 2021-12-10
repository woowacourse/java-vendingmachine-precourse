package vendingmachine;

import inputcontroller.InputGenerator;
import models.Coin;
import models.Product;

import java.util.HashMap;

public class VendingMachineMain {
    public static int totalCoin;
    public static HashMap<Coin, Integer> coin2Num;
    public static HashMap<String, Product> name2Product;

    public static void makeInitialCoins() {
        int amount = InputGenerator.inputInitMoney();

        totalCoin = amount;
        coin2Num = new HashMap<Coin, Integer>();
        VendingMachineDistribution.distributeRandomly();

        VendingMachineUI.printCoins();
    }

    public static void makeInitialProducts() {
        name2Product = new HashMap<String, Product>();
        InputGenerator.inputInitProducts();
        System.out.println(name2Product);
    }
}