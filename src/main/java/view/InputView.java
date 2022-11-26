package view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import dto.HoldingSumRequestDto;
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
        System.out.println(ViewConstant.ASKING_INPUT_PRODUCT_MESSAGE);
        List<String> products = Arrays.stream(Console.readLine().split(";")).collect(Collectors.toList());
        products.forEach(Validator::validateProductForm);
        return new ProductsRequestDto(products);
    }
}
