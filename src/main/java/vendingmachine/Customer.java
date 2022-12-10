package vendingmachine;

import static Constants.CommonValues.FALSE;

import Constants.CommonValues.CustomerState;
import Constants.ErrorMessages;
import UI.InputView;
import java.util.List;

public class Customer {
    private int inputMoney;
    CustomerState customerState;


    public Customer() {
        inputMoney = InputView.askInputMoney();
        customerState = CustomerState.PURCHASE_POSSIBLE;
    }

    public void purchaseProduct(VendingMachine vendingMachine) {
        String wishList;
        while (isCustomerAffordable(vendingMachine, inputMoney)) {
            wishList = InputView.askWishList(inputMoney);
            if (!isWishListAvailable(vendingMachine, wishList)) {
                continue;
            }
            vendingMachine.decreaseStock(wishList);
            decreaseMoney(vendingMachine, wishList);
        }
    }

    private boolean isCustomerAffordable(VendingMachine vendingMachine, int inputMoney) {
        List<Product> productShelf = vendingMachine.getShelf();
        if (!hasSomethingToSell(productShelf)
                || !hasMoneyToBuySomething(inputMoney, productShelf)) {
            return false;
        }
        return true;
    }

    private boolean hasSomethingToSell(List<Product> productShelf) {
        for (Product product : productShelf) {
            if (product.askStockLeft() > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean hasMoneyToBuySomething(int inputMoney, List<Product> productShelf) {
        for (Product product : productShelf) {
            if (inputMoney > product.askPrice()) {
                return true;
            }
        }
        return false;
    }


    private boolean isWishListAvailable(VendingMachine vendingMachine, String wishList) {
        try {
            if (vendingMachine.hasSuchProduct(wishList) == FALSE
                    || vendingMachine.getPrice(wishList) > inputMoney) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_CANNOT_BUY_THE_PRODUCT);
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private void decreaseMoney(VendingMachine vendingMachine, String wishList) {
        int price = vendingMachine.getPrice(wishList);
        inputMoney -= price;
    }

    public int getInputMoney() {
        return inputMoney;
    }

}
