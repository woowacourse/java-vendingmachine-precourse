package vendingmachine.view.input;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.PurchaseValidator;
import vendingmachine.constant.Input;
import vendingmachine.constant.Output;
import vendingmachine.domain.Money;
import vendingmachine.domain.ProductRepository;
import vendingmachine.domain.ReturnCoin;

public class PurchaseInputView {

    private String inputInit() {
        divisionLine();
        System.out.println(Output.PURCHASE_MONEY.getText() + Money.getInstance().getMoney() + Output.WON.getText());
        System.out.println(Input.PRODUCT_PURCHASE_GUIDE_MESSAGE.getText());
        return Console.readLine();
    }

    public void inputProductForPurchase() {
        while (true) {
            if (!ReturnCoin.getInstance().canReturn(Money.getInstance().getMoney())) {
                return;
            }

            String productName = inputInit();
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

    private void divisionLine() {
        System.out.println();
    }
}
