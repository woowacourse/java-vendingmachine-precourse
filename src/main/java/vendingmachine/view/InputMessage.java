package vendingmachine.view;

public class InputMessage {

    public void printNewLine() {
        System.out.println();
    }

    public void printInputMessage(String message) {
        printNewLine();
        System.out.println(message);
    }
}
