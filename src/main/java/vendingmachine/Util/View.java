package vendingmachine.Util;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Domain.Change;
import vendingmachine.Domain.Product;

import java.util.List;

public class View extends Print {

    Validation validate = new Validation();
    Caster cast = new Caster();

    public Change getInitChanges() {
        inputChanges();
        String inputChangeCost = Console.readLine();

        int changeMoney;
        try {
            changeMoney = validate.inputMoneyForChanges(inputChangeCost);
            validate.inputMoneyDivision(changeMoney);
            return cast.toChangeCoins(changeMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInitChanges();
        }
    }

    public List<Product> getInitProducts() {
        inputProductInfo();
        String order = Console.readLine();

        try {
            validate.productOrder(order);
            return cast.toProducts(order);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInitProducts();
        }

    }

    public int getPurchaseMoney() {
        inputPurchaseMoney();
        String inputMoney = Console.readLine();

        try {
            int purchaseMoney = validate.inputMoneyForChanges(inputMoney);
            validate.inputMoneyDivision(purchaseMoney);
            return purchaseMoney;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseMoney();
        }
    }

    public String getProductNameToBuy(List<Product> product) {
        inputProductToBuy();
        String name = Console.readLine();

        try {
            validate.productNameExist(name, product);
            validate.productSoldOut(name, product);
            return name;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getProductNameToBuy(product);
        }

    }

}
