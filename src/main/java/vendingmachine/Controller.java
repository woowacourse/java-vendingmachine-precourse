package vendingmachine;

public class Controller {

    private Change change;

    public static void start() {
        Change change = new Change(Input.inputChanges());
    }
}
