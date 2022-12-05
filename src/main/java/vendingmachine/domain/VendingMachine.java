package vendingmachine.domain;

import vendingmachine.util.Message;

import static vendingmachine.util.Message.*;

public class VendingMachine {
    private final Change change;
    private final Shelf shelf;
    private int amount;

    public VendingMachine(Change change, Shelf shelf, int amount) {
        this.change = change;
        this.shelf = shelf;
        this.amount = amount;
    }
    // 최저 가격보다 amount 가 작을 때, 모든 상품이 소진되었을 때 끝
    public boolean isEndSate(){
        if(shelf.getMinPrice() > amount || shelf.allProductSoldOut())return true;
        return false;
    }
    public void buyProduct(String name){
        shelf.consumeProduct(name);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(MACHINE_PREFIX.getMessage() + amount +"\n");
        print.append(MACHINE_SUFFIX.getMessage());
        return null;
    }
}
