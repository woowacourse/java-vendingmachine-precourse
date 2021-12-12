package vendingmachine.validator;

import vendingmachine.constant.Condition;
import vendingmachine.constant.Input;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class PurchaseValidator {

    public void tryToInputProductForPurchase(String productName) throws IllegalArgumentException{
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

        if (findProduct.get(Condition.INDEX_0.getNumber()).getCost() > Money.getInstance().getMoney()) {
            System.out.println(Input.PRODUCT_PURCHASE_LACK_MONEY_ERROR_MESSAGE.getText());
            throw new IllegalArgumentException();
        }
    }
}
