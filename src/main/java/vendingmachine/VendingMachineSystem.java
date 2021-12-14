package vendingmachine;

import java.util.List;

import vendingmachine.domain.Product;
import vendingmachine.domain.Customer;
import vendingmachine.domain.VendingMachine;

public class VendingMachineSystem {
    private final InputVendingMachineController inputController;
    private final OutPutVendingMachineController outputController;

    public VendingMachineSystem() {
        inputController = new InputVendingMachineController();
        outputController = new OutPutVendingMachineController();
    }

    public void start() {
        int holdingMoney = inputController.inputHoldingMoney();
        VendingMachine vendingMachine = new VendingMachine(holdingMoney);
        outputController.printConsoleMessage(vendingMachine.toString());
        List<Product> products = inputController.inputProductNameAndPriceAndStock();
        vendingMachine.saveProduct(products);
        int customerInsertMoney = inputController.inputCustomerInsertMoney();
        Customer customer = new Customer(customerInsertMoney);
        vendingMachine.settingPutMoneyCustomer(customer);
        while (vendingMachine.isProductsAvailableForPurchase()) {
            outputController.printConsoleMessage(vendingMachine.toStringCustomerInputMoney());
            String productNameToBuy = inputController.inputProductNameToBuy();
            vendingMachine.pay(productNameToBuy);
        }
        outputController.printConsoleMessage(vendingMachine.toStringCustomerInputMoney());
        outputController.printConsoleMessage(vendingMachine.printCustomerChange());
    }
}
