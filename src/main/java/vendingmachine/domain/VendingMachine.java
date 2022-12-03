package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
    private final Products products;
    private int amountPrice;
    private final Change change;

    public VendingMachine(Products products, int amountPrice, Change change) {
        this.products = products;
        this.change = change;
        this.amountPrice = amountPrice;

    }

    public void buy(String buyProduct){
        amountPrice -= products.buy(buyProduct);
    }
    public boolean isFinish(){
        return products.checkContinue(amountPrice);
    }


    @Override
    public String toString() {
        return String.valueOf(amountPrice);
    }
    public String lastPrint(){
        StringBuilder print = new StringBuilder();
        print.append("투입금액:" +amountPrice+"원\n");
        print.append(change.lastChangePrint());
        return print.toString();
    }
}
