package vendingmachine.view.io;

public class Printer {
    private Printer(){}

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printUsingFormat(String format, Object... args){
        System.out.printf(format, args);
        System.out.println();
    }
}
