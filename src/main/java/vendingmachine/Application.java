package vendingmachine;

import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachine vendingMachine = new VendingMachine();
        try{
            vendingMachine.start();
        } catch (NoSuchElementException e) {
        }
    }
}
