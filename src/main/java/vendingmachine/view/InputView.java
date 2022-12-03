package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Product;
import vendingmachine.enums.Coin;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final OutputView outputView = new OutputView();

    public int inputChange() {
        return getAndValidateChange();
    }

    private Integer getAndValidateChange() {
        String inputChange = "";
        while (!inputChange.equals("")) {
            outputView.askInputPricePrint();
            try {
                inputChange = Console.readLine();
                inputDigitValidation(inputChange);
                changeDivideTen(inputChange);
            } catch (IllegalArgumentException e) {
                inputChange = "";
            }
        }
        return Integer.parseInt(inputChange);
    }

    private void changeDivideTen(String inputChange) {
        if (!Coin.isDivideMinCoin(inputChange)) throw new IllegalArgumentException("[ERROR] 잔돈이 나눠지지 않습니다.");
    }

    private void inputDigitValidation(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야합니다.");
        }
    }

    public List<Product> inputProducts(){
        String input = Console.readLine();
        List<Product> products = new ArrayList<>();
        String[] splitProduct = input.split(";");
        for(String product : splitProduct){
            String[] value = product.split(",");
            products.add(new Product(value[0],Integer.parseInt(value[1]), Integer.parseInt(value[2])));
        }
        return products;
    }
}
