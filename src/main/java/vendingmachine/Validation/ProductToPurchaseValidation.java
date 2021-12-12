package vendingmachine.Validation;

import vendingmachine.Constant.ErrorConstant;
import vendingmachine.Domain.Product;
import vendingmachine.Domain.VendingMachine;

public class ProductToPurchaseValidation {
    public void isValid(String name) {
        Product target = VendingMachine.findProductByName(name);
        isExistProduct(target);
        isRemainingProduct(target);
        canPurchaseWithThat(target);
    }

    private void isExistProduct(Product target) {
        if (target == null) {
            throw new IllegalArgumentException(ErrorConstant.NOT_EXIST_PRODUCT);
        }
    }

    private void isRemainingProduct(Product target) {
        if (!target.isRemain()) {
            throw new IllegalArgumentException(ErrorConstant.IS_NOT_REMAINING);
        }
    }

    public void canPurchaseWithThat(Product target) {
        if (!target.canPurchase()) {
            throw new IllegalArgumentException(ErrorConstant.CANT_PURCHASE_WITH_THAT);
        }
    }
}
