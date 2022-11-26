package view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import dto.HoldingSumRequestDto;
import dto.MoneyRequestDto;
import dto.MoneyResponseDto;
import dto.ProductNameRequestDto;
import dto.ProductsRequestDto;
import util.Validator;

public class InputView {
    public HoldingSumRequestDto readHolingSum() {
        System.out.println(ViewConstant.ASKING_INPUT_HOLDING_SUM);
        String holdingSum = Console.readLine();
        Validator.validatePositiveInteger(holdingSum);
        return new HoldingSumRequestDto(Integer.parseInt(holdingSum));
    }

    public ProductsRequestDto readProducts() {
        System.out.println();
        System.out.println(ViewConstant.ASKING_INPUT_PRODUCT_MESSAGE);
        List<String> products = Arrays.stream(Console.readLine().split(";")).collect(Collectors.toList());
        products.forEach(Validator::validateProductForm);
        return new ProductsRequestDto(products);
    }

    public MoneyRequestDto readMoney() {
        System.out.println();
        System.out.println(ViewConstant.ASKING_INPUT_MONEY);
        String money = Console.readLine();
        Validator.validatePositiveInteger(money);
        return new MoneyRequestDto(Integer.parseInt(money));
    }

    public ProductNameRequestDto readProductName(MoneyResponseDto moneyResponseDto) {
        System.out.println();
        System.out.printf(ViewConstant.CURRENT_MONEY, moneyResponseDto.getMoney());
        System.out.println(ViewConstant.ASKING_INPUT_PRODUCT_NAME);
        return new ProductNameRequestDto(Console.readLine());
    }
}
