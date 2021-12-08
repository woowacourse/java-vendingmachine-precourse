package vendingmachine;

import vendingmachine.Model.VendingMachine;

public class Validator {

    public static boolean isValidateMoney(String input) {
        if (!isErrorInNumberFormat(input)) {
            return false;
        }
        int inputNumber = Integer.parseInt(input);
        if (!isPositiveNumber(inputNumber) || !isMultipleOfTen(inputNumber)) {
            return false;
        }
        return true;
    }

    public static boolean isValidateDrinkList(String input) {
        int flag = 1;
        String[] drinks = input.split(";");
        for (String drink : drinks) {
            flag *= isValidateDrinkInfo(drink);
        }
        return (flag == 1);
    }

    public static int isValidateDrinkInfo(String input) {
        input = input.substring(1, input.length() - 1);
        String[] drinkInfo = input.split(",");
        if(!isValidateInfoFormat(drinkInfo)){

        }
        if(!isValidatePrice(drinkInfo[1]) || !isValidateAmount(drinkInfo[2])){
            return 0;
        }
        return 1;
    }
    public static boolean isValidateInfoFormat(String[] input){
        try{
            if(input.length!=3){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            System.out.println("잘못된 입력 형식입니다.");
            return false;
        }
        return true;
    }

    public static boolean isValidatePrice(String input) {
        if (!isErrorInNumberFormat(input)) {
            return false;
        }
        int inputNumber = Integer.parseInt(input);
        if (!isBiggerThan100(inputNumber) || !isMultipleOfTen(inputNumber)) {
            return false;
        }
        return true;
    }

    public static boolean isValidateAmount(String input) {
        if (!isErrorInNumberFormat(input)) {
            return false;
        }
        int inputNumber = Integer.parseInt(input);
        if (!isPositiveNumber(inputNumber)) {
            return false;
        }
        return true;
    }

    public static boolean isErrorInNumberFormat(String input) {
        try {
            if (!isNumberFormat(input)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("금액은 숫자여야 합니다.");
            return false;
        }
        return true;
    }

    public static boolean isNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isMultipleOfTen(int input) {
        try {
            if ((input % 10) != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("금액의 최소단위는 10원입니다.");
            return false;
        }
        return true;
    }

    public static boolean isPositiveNumber(int input) {
        try {
            if (input < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("금액은 음수일 수 없습니다.");
            return false;
        }
        return true;
    }

    public static boolean isBiggerThan100(int input) {
        try {
            if (input < 100) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("상품가격은 100원 이상이어야 합니다.");
            return false;
        }
        return true;
    }

    public static boolean isValidateChoice(String input, VendingMachine vendingMachine){
        try{
            if(vendingMachine.isDrinkInList(input)){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e){
            System.out.println("존재하지 없는 상품입니다.");
            return false;
        }
        return true;
    }
}
