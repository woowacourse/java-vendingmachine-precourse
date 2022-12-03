package vendingmachine.service;

import vendingmachine.domain.Change;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineService {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public void play(){

        int changeAmount = inputView.inputChange();
        Change change = new Change(changeAmount);
        outputView.printFirstChange(change);
        Products products = inputView.inputProducts();
        int inputAmount = inputView.inputAmount();
        VendingMachine vendingMachine = new VendingMachine(products, inputAmount, change);
        while(vendingMachine.isFinish()){
            inputView.inputBuyProduct(vendingMachine);
        }
        outputView.printLastChange(vendingMachine.lastPrint());
    }
}
