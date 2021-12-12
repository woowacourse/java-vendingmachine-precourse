package vendingmachine;

import vendingmachine.view.ChangeReturnView;
import vendingmachine.view.MoneyInputView;
import vendingmachine.view.ProductInitializeView;
import vendingmachine.view.ProductPurchaseView;
import vendingmachine.view.RetentionMoneyInitializeView;
import vendingmachine.view.VendingMachineView;

public class Application {
    public static void main(String[] args) {
        showView(new RetentionMoneyInitializeView());
        showView(new ProductInitializeView());
        showView(new MoneyInputView());
        showView(new ProductPurchaseView());
        showView(new ChangeReturnView());
    }

    public static void showView(VendingMachineView view) {
        while(view.isShow()) {
            view.show();
        }
    }
}
