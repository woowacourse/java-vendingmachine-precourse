package vendingmachine;

public class Application {
    public static void main(String[] args) {
        Message message = new Message();
        User user = new User();
        Change change = new Change();

        message.printInputHolding();
        int holding = user.inputHolding();
        change.makeCoins(holding);
    }
}
