package vendingmachine;

public class Application {
    public static void main(String[] args) {
        Message message = new Message();
        User user = new User();

        message.printInputHolding();
        int holding = user.inputHolding();
    }
}
