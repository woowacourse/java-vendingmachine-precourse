package vendingmachine;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class InputManager {
    public static final String PREFIX_ERROR = "[ERROR]";

    public String getUserInput(String guide) {
        System.out.println(guide);
        String userInput = Console.readLine();
        System.out.println();
        return userInput;
    }

    public VendingMachine setVendingMachine() {
        while (true) {
            String inputData = getUserInput("자판기가 보유하고 있는 금액을 입력해 주세요.");
            try {
                return new VendingMachine(Validators.validateAmount(inputData));
            } catch (IllegalArgumentException e) {
                System.out.println(PREFIX_ERROR + " 0 또는 자연수만 입력 가능합니다.");
            }
        }
    }

    public ArrayList<Item> setItemList() {
        while (true) {
            String inputData = getUserInput("상품명과 가격, 수량을 입력해 주세요.");
            try {
                return Validators.validateItem(inputData);
            } catch (IllegalArgumentException e) {
                System.out.println(PREFIX_ERROR + " 잘못된 상품 입력입니다.");
            }
        }
    }

    public int setUserAmount() {
        while (true) {
            String inputData = getUserInput("투입 금액을 입력해주세요.");
            try {
                return Validators.validateIntegerString(inputData);
            } catch (IllegalArgumentException e) {
                System.out.println(PREFIX_ERROR + " 잘못된 금액 입력입니다.");
            }
        }
    }
}
