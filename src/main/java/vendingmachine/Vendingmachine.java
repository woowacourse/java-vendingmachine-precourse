package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vendingmachine {
    public static String status = "operating";
    private List<Product> products;
    private int Amount;
    private List<String> purchased_products = new ArrayList<>();
    private final InputView inputview = new InputView();
    private final OutputView outputview = new OutputView();
    List<Integer> own_coins;

    public Vendingmachine() {
        Amount=Integer.parseInt(inputview.readCoins());
        own_coins = setCoins(Amount);
        outputview.vending_changes();
        outputview.totalConins(own_coins);
        products = set_vending_products(inputview.readproduct_list(inputview.readProductsformat()));
        Amount = inputview.readbuyingAmount();

        //
        do {
            outputview.printAmount(Amount);
            purchased_products.add(inputview.purchaseproduct());
            calculate();

        } while (status.equals("operating"));


        outputview.print_amount(Amount);
       // setCoins(Amount);
        outputview.changes();
        outputview.total_conins(own_coins);


    }

    public List<Product> set_vending_products(List<String> products_format) {
        List<Product> products = new ArrayList<>();
        String[] list;
        for (String option : products_format) {
            list = option.split(",");

            products.add(new Product(list[0], list[1], list[2]));
        }
        return products;
    }

    public List<Integer> set_coins(int Amount) {
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

    public void calculate() {
        for (int i = 0; i < products.size(); i++) {
            for (String purchased : purchased_products) {
                if (products.get(i).getname().equals(purchased)) {
                    if (products.get(i).getprice() < Amount) {
                        Amount = Amount - products.get(i).getprice();
                    }
                }
            }
        }status="end";

    }
}

