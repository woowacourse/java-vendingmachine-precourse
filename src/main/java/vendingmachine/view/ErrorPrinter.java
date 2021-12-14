package vendingmachine.view;

import java.io.PrintStream;

public class ErrorPrinter {

    private static final PrintStream errStream = System.out;
    private static final String ERR_HEADER = "[ERROR]";

    public static void printError(Exception e) {
        errStream.println(ERR_HEADER + e.getMessage());
    }
}
