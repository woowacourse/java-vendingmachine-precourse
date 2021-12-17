package vendingmachine;

import vendingmachine.domain.Change;
import vendingmachine.domain.Customer;
import vendingmachine.domain.Product;
import vendingmachine.domain.ProductList;
import vendingmachine.validator.ValidatorOld;
import vendingmachine.view.LoopInput;
import vendingmachine.view.OutputMessage;

public class VendingMachine extends LoopInput {
    private static final String BUY_PRODUCT_MESSAGE = "구매할 상품명을 입력해 주세요.";
    private static final Change change = new Change();
    private static final ValidatorOld VALIDATOR_OLD = new ValidatorOld();
    private static final Customer customer = new Customer();
    private static final ProductList productList = new ProductList();
    private static final OutputMessage outputMessage = new OutputMessage();

    public VendingMachine() {
        this.initializeVendingMachine();
    }

    public void run() {
        customer.input();
        while (checkAvailableSellState()) {
            this.input();
        }
        change.returnChange(customer.getCustomerMoney());
    }

    public void inputMethod() {
        this.inputSellProduct();
    }

    private void initializeVendingMachine() {
        change.input();
        productList.input();
        change.createRandomChange();
    }

    private void inputSellProduct() {
        String productName = inputString(BUY_PRODUCT_MESSAGE);
        VALIDATOR_OLD.validateExistedProduct(productList, productName);
        VALIDATOR_OLD.validateProductIsAvailable(productList, productName);
        Product sellProduct = productList.sellProduct(productName);
        customer.calcCustomerMoney(sellProduct);
        outputMessage.printInputMoney(customer.getCustomerMoney());
    }

    private boolean checkAvailableSellState() {
        return productList.checkAvailableState(customer.getCustomerMoney());
    }
}
