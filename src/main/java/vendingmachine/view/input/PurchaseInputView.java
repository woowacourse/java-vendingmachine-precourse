package vendingmachine.view.input;

import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Condition;
import vendingmachine.constant.Input;
import vendingmachine.constant.Output;
import vendingmachine.domain.Product;
import vendingmachine.domain.ProductRepository;
import vendingmachine.domain.ReturnCoin;

public class PurchaseInputView {
    private Integer money;

    public PurchaseInputView(Integer money) {
        this.money = money;
    }

    private String inputInit() {
        System.out.println(Output.PURCHASE_MONEY.getText() + money + Output.WON.getText());
        System.out.println(Input.PRODUCT_PURCHASE_GUIDE_MESSAGE.getText());
        return Console.readLine();
    }

    public void inputProductForPurchase() {
        while (true) {
            if (!ReturnCoin.getInstance().canReturn(money)) {
                return;
            }

            String productName = inputInit();
            try {
                tryToInputProductForPurchase(productName);
                purchaseProduct(productName);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void tryToInputProductForPurchase(String productName) throws IllegalArgumentException{
        validateProductExist(productName);
        validateProductAmountExist(productName);
        validateEnoughMoneyForProductCost(productName);
    }

    private void validateProductAmountExist(String productName) {
        List<Product> products = ProductRepository.getInstance().getProducts();
        List<Product> findProduct = products.stream().
                filter(product -> product.getName().equals(productName)).collect(Collectors.toList());

        if (findProduct.get(Condition.INDEX_0.getNumber()).getQuantity() == 0) {
            System.out.println(Input.PRODUCT_AMOUNT_LACK_ERROR_MESSAGE.getText());
            throw new IllegalArgumentException();
        }
    }

    private void validateProductExist(String productName) {
        List<Product> products = ProductRepository.getInstance().getProducts();
        boolean result = products.stream()
                .anyMatch(product -> product.getName().equals(productName));

        if (!result) {
            System.out.println(Input.PRODUCT_EXIST_ERROR_MESSAGE.getText());
            throw new IllegalArgumentException();
        }
    }

    private void validateEnoughMoneyForProductCost(String productName) {
        List<Product> products = ProductRepository.getInstance().getProducts();
        List<Product> findProduct = products.stream().
                filter(product -> product.getName().equals(productName)).collect(Collectors.toList());

        if (findProduct.get(Condition.INDEX_0.getNumber()).getCost() > money) {
            System.out.println(Input.PRODUCT_PURCHASE_LACK_MONEY_ERROR_MESSAGE.getText());
            throw new IllegalArgumentException();
        }
    }

    private void purchaseProduct(String productName) {
        List<Product> products = ProductRepository.getInstance().getProducts();
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                money -= product.getCost();
                product.sellProduct();
            }
        }
    }
}
