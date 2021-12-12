package vendingmachine.Validation;

import vendingmachine.Constant.DomainConstant;
import vendingmachine.Constant.ErrorConstant;
import vendingmachine.Domain.VendingMachine;

public class ProductValidation {
    CommonValidation common = new CommonValidation();

    public void isValidProductFormat(String productInfo) {
        if (common.isExist(productInfo)
                && checkArrayFormat(productInfo)
                && checkVariables(productInfo.split(DomainConstant.SEPARATE_PRODUCTS_INFO))) {
            return;
        }

        throw new IllegalArgumentException(ErrorConstant.WRONG_INPUT_FORMAT);
    }

    private boolean checkArrayFormat(String input) {
        return (input.charAt(0) == DomainConstant.START_PRODUCTS_INFO
                && input.charAt(input.length() - 1) == DomainConstant.END_PRODUCTS_INFO
                && input.split(DomainConstant.SEPARATE_PRODUCTS_INFO).length == DomainConstant.NUMBER_OF_PRODUCT_FIELDS);
    }

    private boolean checkVariables(String[] input) {
        for (String i : input) {
            if (!common.isExist(i)) {
                return false;
            }
        }
        return true;
    }

    public void isValidProductInfo(String[] productInfo) {
        checkName(productInfo[0]);
        checkCost(productInfo[1]);
        checkCount(productInfo[2]);
    }

    private void checkName(String name) {
        if (VendingMachine.findProductByName(name) != null) {
            throw new IllegalArgumentException(ErrorConstant.PRODUCT_NAME_MUST_NOT_BE_DUPLICATED);
        }
    }

    private void checkCost(String cost) {
        if ((common.isInteger(cost)
                && common.isMoreThanNum(Integer.parseInt(cost), DomainConstant.MINIMUM_NUMBER_OF_COST)
                && common.isDividedByNum(Integer.parseInt(cost), DomainConstant.COST_MUST_BE_DIVIDED))) {
            return;
        }
        throw new IllegalArgumentException(ErrorConstant.WRONG_COST);
    }

    private void checkCount(String count) {
        if ((common.isInteger(count)
                && common.isMoreThanNum(Integer.parseInt(count), DomainConstant.MINIMUM_NUMBER_OF_COUNT))) {
            return;
        }
        throw new IllegalArgumentException(ErrorConstant.WRONG_COUNT);
    }
}
