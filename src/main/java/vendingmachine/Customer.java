package vendingmachine;

import static Constants.CommonValues.FALSE;

import Constants.CommonValues.CustomerState;
import Constants.ErrorMessages;
import UI.InputView;
import UI.OutputView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Customer {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private int inputMoney;
    CustomerState customerState;


    public Customer() {
        inputMoney = inputView.askinputMoney();
        customerState = CustomerState.PURCHASE_POSSIBLE;
    }

    public void purchaseProduct(VendingMachine vendingMachine) {
        String wishList;
        while (checkCustomerState(vendingMachine, inputMoney)) {
            wishList = inputView.askWishList();
            if (!checkStock(vendingMachine, wishList)) {
                continue;
            }
            vendingMachine.decreaseStock(wishList);
            decreaseMoney(vendingMachine, wishList);
        }
    }

    private boolean checkCustomerState(VendingMachine vendingMachine, int inputMoney) {
        List<Product> productShelf = vendingMachine.bringShelf();
        if (!hasSomethingToSell(productShelf)
                && !hasMoneyToBuySomething(inputMoney, productShelf)) {
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


    private boolean checkStock(VendingMachine vendingMachine, String wishList) {
        try {
            if (vendingMachine.hasSuchProduct(wishList)==FALSE
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


}
