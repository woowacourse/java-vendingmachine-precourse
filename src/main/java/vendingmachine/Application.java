package vendingmachine;

import Constants.Coin;
import Controller.VendingMachineCreator;
import UI.OutputView;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        VendingMachineCreator vendingMachineCreator = new VendingMachineCreator();
        VendingMachine vendingMachine = vendingMachineCreator.createVendingMachine();
        Customer customer = new Customer();
        customer.purchaseProduct(vendingMachine);
        Map<Coin, Integer> returnedChanges = vendingMachine.returnChanges(customer);
        OutputView.showReturningChanges(returnedChanges, customer.getInputMoney());
    }
}
