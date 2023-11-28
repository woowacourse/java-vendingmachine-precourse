package vendingmachine.view;

import java.util.List;
import java.util.regex.Pattern;
import vendingmachine.exception.VendingMachineException;
import vendingmachine.view.io.Printer;
import vendingmachine.view.io.Reader;

public class InputView {
    //regex = [글자,숫자,숫자]
    private static final Pattern MENU_REGEX = Pattern.compile("\\[[가-힣]+,\\d+,\\d+\\]");
    private final Reader reader = new Reader();
    private final Printer printer = new Printer();

    public int getMachineMoney() {
        printer.printMessage("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return reader.getInteger();
    }

    public List<String> getMenus() {
        printer.printMessage("상품명과 가격, 수량을 입력해 주세요.");
        List<String> menus = reader.getStringsWithDelimiter(";");
        validateMenuFormat(menus);
        return menus;
    }

    private void validateMenuFormat(List<String> menus) {
        if (allMatchPattern(menus)) {
            return;
        }
        throw VendingMachineException.INVALID_INPUT_FORMAT.makeException();
    }

    private boolean allMatchPattern(List<String> menus) {
        return menus.stream()
                .allMatch(menu -> MENU_REGEX.matcher(menu).matches());
    }

    public int insertMoney() {
        printer.printMessage("투입 금액을 입력해 주세요.");
        return reader.getInteger();
    }

    public String purchaseMenu() {
        printer.printMessage("구매할 상품명을 입력해 주세요.");
        return reader.getString();
    }
}
