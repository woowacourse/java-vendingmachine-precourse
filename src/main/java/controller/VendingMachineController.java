package controller;

import model.Money;
import view.InputView;
import view.OutputView;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class VendingMachineController {

    private final InputView inputView;
    private final OutputView outputView;

    public VendingMachineController(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start(){
        Money money = input(Money::new, inputView::inputVendingMachineMoney);
    }

    private <T,R> R input(Function<T,R> function, Supplier<T> supplier){
        try{
            return function.apply(supplier.get());
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e);
            return input(function,supplier);
        }
    }
}
