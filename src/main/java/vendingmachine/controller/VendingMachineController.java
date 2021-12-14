package vendingmachine.controller;

import vendingmachine.model.Client;
import vendingmachine.model.Products;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.vo.Product;

public class VendingMachineController {
    private VendingMachine vendingMachine;
    private Products products;

    public VendingMachineController setup() {
        Integer initialMoney = InputView.getMoneyInputForVendingMachine();
        this.vendingMachine = VendingMachine.initialize(initialMoney);

        String productInput = InputView.getProductInput();
        this.products = Products.parseProducts(productInput);

        return this;
    }

    public void start() {
        Client client = new Client(InputView.getMoneyInputForPurchase());
        boolean isOnBusiness = true;

        while (isOnBusiness) {
            client.printMoneyLeft();
            String productName = InputView.getProductToPurchase(products);
            Product product = products.getProductByName(productName);
            client.buy(product.getPrice());
            product.sell();
            isOnBusiness = validateBusiness(client);
        }

        client.printMoneyLeft();
        vendingMachine.returnChange(client.getMoney());
    }

    private boolean validateBusiness(Client client) {
        if (products.hasSoldOutProduct()) {
            return false;
        }

        if (client.hasNotEnoughMoney(products.getLowestPrice())) {
            return false;
        }

        return true;
    }

}
