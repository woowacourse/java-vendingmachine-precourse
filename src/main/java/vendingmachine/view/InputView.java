package vendingmachine.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.InvestmentMoney;
import vendingmachine.domain.PossessionMoney;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;

public class InputView {
    private static final String POSSESSION_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    private static final String PRODUCT_SAVE_MESSAGE = "\n상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_PRODUCTS_SPLIT_REGEX = ";";
    private static final int INPUT_PRODUCTS_SPLIT_LIMIT = -1;

    private static final String INVESTMENT_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";

    private InputView() {
    }

    public static PossessionMoney getPossessionMoney() {
        System.out.println(POSSESSION_MONEY_MESSAGE);
        return new PossessionMoney(Console.readLine());
    }

    public static Products getProducts() {
        System.out.println(PRODUCT_SAVE_MESSAGE);
        String[] splitProducts = getSplitInputProducts(Console.readLine());
        List<Product> products = toProductList(splitProducts);

        return new Products(products);
    }

    private static String[] getSplitInputProducts(String inputProducts) {
        return inputProducts.split(INPUT_PRODUCTS_SPLIT_REGEX, INPUT_PRODUCTS_SPLIT_LIMIT);
    }

    private static List<Product> toProductList(String[] splitProducts) {
        return Arrays.stream(splitProducts)
            .map(Product::new)
            .collect(toList());
    }

    public static InvestmentMoney getInvestmentMoney() {
        System.out.println(INVESTMENT_MONEY_MESSAGE);
        return new InvestmentMoney(Console.readLine());
    }
}