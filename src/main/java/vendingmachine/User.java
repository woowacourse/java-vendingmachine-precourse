package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class User {
    String input;
    String ERROR_MESSAGE;
    int machineBalance;

    public boolean inputMachineBalance() {
        try {
            input();
            checkCorrectBalance();
        } catch (Exception e){
            System.out.println(ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private void input() {
        input = String.valueOf(Console.readLine());
    }
    private void checkCorrectBalance() throws IllegalArgumentException{
        checkBlank(input);
        checkCharacter(input);
        machineBalance = Integer.parseInt(input);
        checkNegativeNumber(machineBalance);
        checkMultipleOfTen(machineBalance);
    }
    private void checkBlank(String input) throws IllegalArgumentException {
        if (input.equals("")) {
            ERROR_MESSAGE = Message.ERROR_MACHINE_BALANCE_BLANK;
            throw new IllegalArgumentException();
        }
    }
    private void checkCharacter(String input) throws IllegalArgumentException {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                ERROR_MESSAGE = Message.ERROR_MACHINE_BALANCE_CHARACTER;
                throw new IllegalArgumentException();
            }
        }
    }
    private void checkNegativeNumber(int number) throws IllegalArgumentException {
        if (number < 0) {
            ERROR_MESSAGE = Message.ERROR_MACHINE_BALANCE_NEGATIVE_NUMBER;
            throw new IllegalArgumentException();
        }
    }
    private void checkMultipleOfTen(int number) throws IllegalArgumentException {
        if (!(number % 10 == 0)) {
            ERROR_MESSAGE = Message.ERROR_MACHINE_BALANCE_MULTIPLE_OF_TEN;
            throw new IllegalArgumentException();
        }
    }


}
