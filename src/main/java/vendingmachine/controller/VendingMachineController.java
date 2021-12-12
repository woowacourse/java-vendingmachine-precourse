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

public class VendingMachineController {

    private final ChangeService changeService = new ChangeService();
    private final MoneyService moneyService = new MoneyService();
    private final ProductService productService = new ProductService();
    private final VendingMachineService vendingMachineService = new VendingMachineService();

    private VendingMachine initVendingMachine() {
        Money money = moneyService.createMoney();

        Change change = changeService.crateChange(money);

        List<Product> productList = productService.createProductListWithInput();

        VendingMachine vendingMachine = vendingMachineService.createVendingMachine(change, productList, money);

        return vendingMachine;
    }
}
