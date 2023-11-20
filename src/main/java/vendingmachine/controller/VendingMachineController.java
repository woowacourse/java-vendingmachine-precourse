package vendingmachine.controller;

import vendingmachine.domain.Products;
import vendingmachine.utils.Convertor;
import vendingmachine.view.Input;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final Input input;

    private VendingMachineController(final Input input) {
        this.input = input;
    }

    public static VendingMachineController from(final Input input) {
        return new VendingMachineController(input);
    }

    public void run(){
        setHoldCoin();
        setProducts();
        setInputAmount();
        //TODO : while(isStilRemainMoney)
        requestWanted();
        spendAll();
    }

    private void setHoldCoin() {
        OutputView.printRequestMachinHoldMoney();
        String inputString = input.readHoldMoney();
        int holdMoney = Convertor.convertToMoney(inputString);
        //TODO : coinService.create
        //TODO : coinService.setCoinsByMoney
        //TODO : printHoldCoin
    }

    private void setProducts() {
        OutputView.printRequestProducts();
        String inputString = input.readProducts();
        Products products = Convertor.convertToProducts(inputString);
    }

    private void setInputAmount() {
        OutputView.printRequestInputAmount();
        String inputString = input.readInputAmount();
        int inputAmount = Convertor.convertToMoney(inputString);
        //TODO : purchaseService create
    }

    private void requestWanted() {
        OutputView.printRequestWanted();
        String inputString = input.readWanted();
        //TODO : purchaseService.purchase
    }

    private void spendAll() {
        //TODO : coinService getRemainCoins()
    }
}
