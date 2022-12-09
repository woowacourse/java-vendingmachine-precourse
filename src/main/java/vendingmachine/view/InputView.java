package vendingmachine.view;

import vendingmachine.domain.Money;
import vendingmachine.domain.products.Products;
import vendingmachine.util.IntConvert;
import vendingmachine.util.ProductsConvert;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public Money readMoney() {
        return Money.from(IntConvert.convert(readLine()));
    }

    public Products readProducts() {
        return ProductsConvert.convert(readLine());
    }
}
