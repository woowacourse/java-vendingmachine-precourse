package vendingmachine.validator;

import vendingmachine.constant.Error;
import vendingmachine.domain.ProductRepository;

public class PurchaseValidator {

    public void tryToInputProductForPurchase(String productName) throws IllegalArgumentException{
        validateProductExist(productName);
        validateProductAmountExist(productName);
        validateEnoughMoneyForProductCost(productName);
    }

    private void validateProductAmountExist(String productName) {
        if(!ProductRepository.getInstance().hasProductQuantity(productName)) {
            System.out.println(Error.PRODUCT_AMOUNT_LACK_ERROR_MESSAGE.getError());
            throw new IllegalArgumentException();
        }
    }

    private void validateProductExist(String productName) {
        if (!ProductRepository.getInstance().isProductExist(productName)) {
            System.out.println(Error.PRODUCT_EXIST_ERROR_MESSAGE.getError());
            throw new IllegalArgumentException();
        }
    }

    private void validateEnoughMoneyForProductCost(String productName) {
        if (!ProductRepository.getInstance().canPurchaseProduct(productName)) {
            System.out.println(Error.PRODUCT_PURCHASE_LACK_MONEY_ERROR_MESSAGE.getError());
            throw new IllegalArgumentException();
        }
    }
}
