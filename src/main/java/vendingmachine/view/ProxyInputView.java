package vendingmachine.view;

import vendingmachine.utils.ExceptionHandler;

public class ProxyInputView implements Input {

    private final Input viewable;

    public ProxyInputView(Input viewable) {
        this.viewable = viewable;
    }

    @Override
    public String readHoldMoney() {
        return ExceptionHandler.input(viewable::readHoldMoney, 0);
    }

    @Override
    public String readProducts() {
        return ExceptionHandler.input(viewable::readProducts, 0);
    }

    @Override
    public String readInputAmount() {
        return ExceptionHandler.input(viewable::readInputAmount, 0);
    }

    @Override
    public String readWanted() {
        return ExceptionHandler.input(viewable::readWanted, 0);
    }
}
