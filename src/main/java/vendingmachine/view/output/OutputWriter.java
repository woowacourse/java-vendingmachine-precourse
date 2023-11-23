package vendingmachine.view.output;

import vendingmachine.view.constant.OutputMessage;

sealed class OutputWriter
        permits ErrorOutputWriter, OutputView {

    OutputWriter() {
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printMessageResponse(OutputMessage responseMessage) {
        println(responseMessage.getMessage());
    }
}

