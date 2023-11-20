package vendingmachine.controller;

import vendingmachine.domain.Products;
import vendingmachine.service.PurchaseService;
import vendingmachine.utils.Convertor;
import vendingmachine.utils.ExceptionHandler;
import vendingmachine.view.Input;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final Input input;
    private Products products;
    private PurchaseService purchaseService;

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
        Integer holdMoney = ExceptionHandler.convert(Convertor::convertToMoney, inputString);
        if(holdMoney == null) setHoldCoin();
        //TODO : coinService.create
        //TODO : coinService.setCoinsByMoney
        //TODO : printHoldCoin
    }

    private void setProducts() {
        OutputView.printRequestProducts();
        String inputString = input.readProducts();
        Products products = ExceptionHandler.convert(Convertor::convertToProducts, inputString);
        if(products == null) setProducts();
        this.products = products;
    }

    private void setInputAmount() {
        OutputView.printRequestInputAmount();
        String inputString = input.readInputAmount();
        Integer inputAmount = ExceptionHandler.convert(Convertor::convertToMoney, inputString);
        if(inputAmount == null) setInputAmount();
        purchaseService = PurchaseService.of(products, inputAmount);
        
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
