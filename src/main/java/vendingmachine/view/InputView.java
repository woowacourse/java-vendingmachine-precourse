package vendingmachine.view;

public class InputView {
    private static void isValidPrice(int price){
        if (price%10!=0){
            throw new IllegalArgumentException();
        }
    }
}
