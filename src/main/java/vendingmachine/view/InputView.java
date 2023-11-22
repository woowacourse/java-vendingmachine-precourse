package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import vendingmachine.converter.Parser;
import vendingmachine.dto.ProductInfo;
import vendingmachine.validator.InputValidator;

public class InputView {
    public String getProductName() {
        return readLine();
    }

    public int getInputAmount() {
        return InputValidator.isInteger(readLine());
    }

    public List<ProductInfo> getStockInfo() {
        String input = readLine();
        //TODO: 정규식을 잘못짠듯 다시 하기
//        InputValidator.isValidFormat(input);
        return Parser.parseToProductInfoList(input);
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
