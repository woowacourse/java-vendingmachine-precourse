package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Input;
import vendingmachine.constant.Output;
import vendingmachine.domain.Money;
import vendingmachine.domain.ProductRepository;
import vendingmachine.domain.ChangeCoin;
import vendingmachine.validator.MoneyValidator;
import vendingmachine.validator.ProductValidator;
import vendingmachine.validator.PurchaseValidator;

public class InputView {

    public int inputMoneyForMakeCoin() {
        while (true) {
            print(Input.COIN_MONEY_GUIDE_MESSAGE.getText());
            String money = Console.readLine();
            try {
                MoneyValidator moneyValidator = new MoneyValidator();
                moneyValidator.tryToInputMoneyForMakeCoin(money);
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public int inputMoneyForPurchase() {
        while (true) {
            divisionLine();
            print(Input.PURCHASE_MONEY_GUIDE_MESSAGE.getText());
            String money = Console.readLine();
            try {
                MoneyValidator moneyValidator = new MoneyValidator();
                moneyValidator.tryInputMoneyForPurchase(money);
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public void inputProducts() {
        while (true) {
            print(Input.PRODUCT_GUIDE_MESSAGE.getText());
            String input = Console.readLine();
            String[] products = input.split(Input.SEMICOLON.getText());

            try {
                ProductValidator productValidator = new ProductValidator();
                productValidator.tryToInputProducts(products);
                return;
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private String inputProductForPurchaseInit() {
        divisionLine();
        System.out.println(Output.PURCHASE_MONEY.getText() + Money.getInstance().getMoney() + Output.WON.getText());
        System.out.println(Input.PRODUCT_PURCHASE_GUIDE_MESSAGE.getText());
        return Console.readLine();
    }

    public void inputProductForPurchase() {
        while (true) {
            if (!ChangeCoin.getInstance().canReturnChange(Money.getInstance().getMoney())) {
                return;
            }

            String productName = inputProductForPurchaseInit();
            try {
                PurchaseValidator purchaseValidator = new PurchaseValidator();
                purchaseValidator.tryToInputProductForPurchase(productName);
                updateResourceState(productName);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void updateResourceState(String productName) {
        ProductRepository.getInstance().purchaseProduct(productName);
        Money.getInstance().minusMoney(productName);
    }


    private void print(String message) {
        System.out.println(message);
    }

    private void divisionLine() {
        System.out.println();
    }
}
