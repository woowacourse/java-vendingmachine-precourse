package vendingmachine.view;

public class ProxyInputView implements Input {

    private final Input viewable;

    public ProxyInputView(Input viewable) {
        this.viewable = viewable;
    }

    @Override
    public String readHoldMoney() {
        return null;
    }

    @Override
    public String readProducts() {
        return null;
    }

    @Override
    public String readInputAmount() {
        return null;
    }

    @Override
    public String readWanted() {
        return null;
    }
}
