package vendingmachine;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Vendingmachine {
    // public static String status = "operating";
    private List<String> products_list;
    private int Amount = 0;
    InputView inputview = new InputView();
    List<Integer> own_coins;

    public Vendingmachine() {
        //own_coins= Collections.emptyList();
        // vending_products= inputview.readproduct_list(inputview.read());

    }

    public List<Products> set_vending_products(List<String> products_format) {
        List<Products> products = new ArrayList<>();
        String[] list;
        for (String option : products_format) {
            list = option.split(",");

            products.add(new Products(list[0], list[1], list[2]));
        }
        return products;
    }

    public List<Integer> setCoins(int Amount) {
        int f_hund = (Amount % 1000) / 500;
        int hund_d = (Amount % 500) / 100;
        int fif_ten = (Amount % 100) / 50;
        int ten_d = (Amount % 50) / 10;
       // if (!own_coins.isEmpty()) {
         //   own_coins.clear();
        //}
        own_coins = new ArrayList<>(Arrays.asList(f_hund, hund_d, fif_ten, ten_d));
        return own_coins;
    }

    public void totalConins() {
        System.out.print("자판기가 보유한 동전" + "\n");
        System.out.print(Coin.COIN_500.getAmount() + "원" + " - " + own_coins.get(0) + "개" + "\n");
        System.out.print(Coin.COIN_100.getAmount() + "원" + " - " + own_coins.get(1) + "개" + "\n");
        System.out.print(Coin.COIN_50.getAmount() + "원" + " - " + own_coins.get(2) + "개" + "\n");
        System.out.print(Coin.COIN_10.getAmount() + "원" + " - " + own_coins.get(3) + "개" + "\n");
    }



}
