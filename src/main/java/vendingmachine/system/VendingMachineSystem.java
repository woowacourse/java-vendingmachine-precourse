package vendingmachine.system;

import java.util.List;

import vendingmachine.configuration.DependencyInjectionContainer;
import vendingmachine.controller.InputVendingMachineController;
import vendingmachine.controller.OutPutVendingMachineController;
import vendingmachine.domain.Product;
import vendingmachine.domain.Customer;
import vendingmachine.domain.VendingMachine;

public class VendingMachineSystem {
    private final InputVendingMachineController inputController;
    private final OutPutVendingMachineController outputController;

    public VendingMachineSystem() {
        DependencyInjectionContainer dependencyInjectionContainer = new DependencyInjectionContainer();
        inputController = dependencyInjectionContainer.inputVendingMachineController();
        outputController = dependencyInjectionContainer.outPutVendingMachineController();
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
