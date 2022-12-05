package vendingmachine.controller;

import vendingmachine.domain.Change;
import vendingmachine.domain.Product;
import vendingmachine.domain.Shelf;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.View;

import java.util.List;

public class MachineController {
    View view = new View();
    public void play(){
        Change change = view.inputChange();
        view.printChange(change.startChangePrint());
        setProduct(change);
    }

    private void setProduct(Change change) {
        List<Product> products = view.inputProducts();
        createVendingMachine(change, products);

    }

    private void createVendingMachine(Change change, List<Product> products) {
        int amount = view.inputAmount();
        VendingMachine vendingMachine = new VendingMachine(change, new Shelf(products), amount);
        untilEnd(vendingMachine, change);
    }

    private void untilEnd(VendingMachine vendingMachine, Change change) {
        while(!vendingMachine.isEndSate()){
            view.inputBuyProduct(vendingMachine);
        }
        view.printChange(change.leftChangePrint());
    }
}
