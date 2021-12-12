package vendingmachine.controller;

import vendingmachine.domain.Change;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.ChangeService;
import vendingmachine.service.MoneyService;
import vendingmachine.service.ProductService;
import vendingmachine.service.VendingMachineService;

import java.util.List;

import static vendingmachine.view.OutputView.*;

public class VendingMachineController {

    private final ChangeService changeService = new ChangeService();
    private final MoneyService moneyService = new MoneyService();
    private final ProductService productService = new ProductService();
    private final VendingMachineService vendingMachineService = new VendingMachineService();

    public void runVendingMachine() {
        VendingMachine vendingMachine = initVendingMachine();

        vendingMachineService.progressVendingMachine(vendingMachine);

        printVendingMachineChangeResult(vendingMachine);
    }

    private VendingMachine initVendingMachine() {
        Money money = moneyService.createHoldingMoney();

        Change change = changeService.crateChange(money);

        printVendingMachineChange(change);

        List<Product> productList = productService.createProducts();

        Money inputMoney = moneyService.createInputMoney();

        VendingMachine vendingMachine = vendingMachineService.createVendingMachine(change, productList, inputMoney);

        return vendingMachine;
    }
}
