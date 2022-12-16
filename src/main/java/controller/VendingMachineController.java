package controller;

import model.CoinGenerator;
import model.Money;
import model.VendingMachine;
import view.InputView;
import view.OutputView;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class VendingMachineController {

    private final InputView inputView;
    private final OutputView outputView;
    private VendingMachine vendingMachine;

    public VendingMachineController(){
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start(){
        Money money = input(Money::new, inputView::inputVendingMachineMoney);
        CoinGenerator.generate(money.getAmount());
        outputView.printVendingMachineCoin();
        vendingMachine= input(VendingMachine::new, inputView::inputProduct);
        vendingMachine.setMoney(money);

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
