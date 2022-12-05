package vendingmachine.Util;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Domain.Change;
import vendingmachine.Domain.Product;
import vendingmachine.Util.Validation.ProductInspector;
import vendingmachine.Util.Validation.Validation;

import java.util.List;

public class View extends Print {

    Validation validate = new Validation();
    ProductInspector inspector = new ProductInspector();

    Caster cast = new Caster();

    public Change getInitChanges() {
        inputChanges();
        String inputChangeCost = Console.readLine();

        int changeMoney;
        try {
            changeMoney = validate.inputNumber(inputChangeCost);
            validate.inputMoneyDivision(changeMoney);
            return cast.toChangeCoins(changeMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInitChanges();
        }
    }

    public List<Product> getInitProducts() {
        inputProductInfo();
        String inputOrder = Console.readLine();

        try {
            inspector.inputInitOrder(inputOrder);
            return cast.toProducts(inputOrder);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInitProducts();
        }

    }

    public int getPurchaseMoney() {
        inputPurchaseMoney();
        String inputMoney = Console.readLine();

        try {
            int purchaseMoney = validate.inputNumber(inputMoney);
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
            inspector.productNameExist(name, product);
            inspector.productSoldOut(name, product);
            return name;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getProductNameToBuy(product);
        }

    }

}
