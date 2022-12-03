package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
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
        while (inputChange.equals("")) {
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

    public Products inputProducts(){
        return validateProducts();
    }
    private Products validateProducts(){
        String productsInput = "";
        List<Product> products = new ArrayList<>();
        int minAmount = Integer.MAX_VALUE;
        while(productsInput.equals("")){
            outputView.askProductPrint();
            try{
                productsInput = Console.readLine();
                String[] splitProduct = productsInput.split(";");
                for(String product : splitProduct){
                    String[] value = product.split(",");
                    products.add(new Product(value[0],Integer.parseInt(value[1]), Integer.parseInt(value[2])));
                    validateProductPrice(Integer.parseInt(value[1]));
                    minAmount = Math.min(minAmount, Integer.parseInt(value[1]));
                }
            }catch (IllegalArgumentException e){
                productsInput = "";
                products = new ArrayList<>();
            }
        }
        return new Products(products, minAmount);
    }


    private void validateProductPrice(int price) {
        if(!(price >100 && Coin.isDivideMinCoin(String.valueOf(price))))throw new IllegalArgumentException(
                "[ERROR] 상품 금액이 잘못됐습니다."
        );
    }

    public int inputAmount(){
        return getAndValidateChange();
    }


}
