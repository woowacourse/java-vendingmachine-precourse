package vendingmachine.domain.vendingMachine;

import vendingmachine.domain.product.ProductService;
import vendingmachine.domain.product.Products;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineRegister {
    private VendingMachineAmount vendingMachineAmount;
    private Products products;

    public VendingMachineRegister() {
    }

    public void run() {
        setVendingMachineAmount();
        OutputView.printCoinCount(vendingMachineAmount.getVendingMachineCoinCombination());
        setProduct();
    }

    public void setVendingMachineAmount() {
        try {
            vendingMachineAmount = new VendingMachineAmount(InputView.getVendingMachineAmount());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setVendingMachineAmount();
        }
    }

    private void setProduct() {
        try {
            products = ProductService.makeProducts(InputView.getProducts());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setProduct();
        }
    }

    public Products getProducts() {
        return products;
    }
}