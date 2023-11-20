package vendingmachine.view;

import java.util.List;
import java.util.regex.Pattern;
import vendingmachine.exception.VendingMachineException;
import vendingmachine.view.io.Printer;
import vendingmachine.view.io.Reader;

public class InputView {
    private static final Pattern menuInputPattern = Pattern.compile("\\[\\W*,\\d*,\\d*\\]");
    private static final Pattern menuNamePattern = Pattern.compile("\\W*");
    private InputView(){}

    public static int getCoinMoney(){
        Printer.printMessage("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return Reader.getInteger();
    }

    public static List<String> getMenus(){
        Printer.printMessage("상품명과 가격, 수량을 입력해 주세요.");
        List<String> menuInputs = Reader.getStrings();
        menuInputs.forEach(InputView::validateMenuPattern);
        return menuInputs;
    }

    private static void validateMenuPattern(String input){
        if(!menuInputPattern.matcher(input).matches()){
            throw VendingMachineException.INVALID_STRING_FORMAT.makeException();
        }
    }

    public static int getInitMoney(){
        Printer.printMessage("투입 금액을 입력해 주세요.");
        return Reader.getInteger();
    }

    public static String getMenuName(){
        Printer.printMessage("구매할 상품명을 입력해 주세요.");
        String menuName = Reader.getString();
        if(!menuNamePattern.matcher(menuName).matches()){
            throw VendingMachineException.INVALID_STRING_FORMAT.makeException();
        }
        return menuName;
    }
}
