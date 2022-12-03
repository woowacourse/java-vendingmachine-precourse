package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.enums.Coin;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private final OutputView outputView = new OutputView();

    public int inputChange() {
        outputView.askPricePrint();
        String inputChange = "";
        while (inputChange.equals("")) {
            inputChange = getAndValidateChange(Console.readLine());
        }
        return Integer.parseInt(inputChange);
    }

    private String getAndValidateChange(String inputChange) {
        try {
            inputDigitValidation(inputChange);
            changeDivideTen(inputChange);
        } catch (IllegalArgumentException e) {
            outputView.printLastChange(e.getMessage());
            return "";
        }
        return inputChange;
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

    public Products inputProducts() {
        return validateProducts();
    }

    private Products validateProducts() {
        String productsInput = "";
        List<Product> products = new ArrayList<>();
        int minPrice = Integer.MAX_VALUE;
        while (productsInput.equals("")) {
            outputView.askProductPrint();
            try {
                productsInput = Console.readLine();
                String[] splitProduct = productsInput.split(";");
                for (String product : splitProduct) {
                    String[] value = product.substring(1, product.length() - 1).split(",");
                    String productName = value[0];
                    inputDigitValidation(value[1]);
                    inputDigitValidation(value[2]);
                    int productPrice = Integer.parseInt(value[1]);
                    int productQuantity = Integer.parseInt(value[2]);
                    validateProductPrice(productPrice);
                    validateProductQuantity(productQuantity);
                    products.add(new Product(productName, productPrice, productQuantity));
                    minPrice = Math.min(minPrice, productPrice);
                }
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
                productsInput = "";
                products = new ArrayList<>();
            }
        }
        return new Products(products, minPrice);
    }

    private void validateProductQuantity(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("[ERROR] 수량은 0보다 커야합니다.");
    }


    private void validateProductPrice(int price) {
        if (price > 100 && Coin.isDivideMinCoin(String.valueOf(price))) return;
        throw new IllegalArgumentException("[ERROR] 상품 금액이 잘못됐습니다.");
    }

    public int inputAmount() {
        outputView.askInputPricePrint();
        String inputAmount = "";
        while(inputAmount.equals("")){
            inputAmount = getAndValidateAmount(Console.readLine());
        }
        return Integer.parseInt(inputAmount);
    }
    private String getAndValidateAmount(String inputAmount) {
        try {
            inputDigitValidation(inputAmount);
            changeDivideTen(inputAmount);
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return "";
        }
        return inputAmount;
    }

    public String inputBuyProduct(VendingMachine vendingMachine) {
        outputView.askBuyProductPrint(vendingMachine.toString());
        String buyProduct = "";
        while (buyProduct.equals("")) {
            try {
                buyProduct = Console.readLine();
                vendingMachine.buy(buyProduct);
            } catch (IllegalArgumentException e) {
                outputView.printMessage(e.getMessage());
                buyProduct = "";
            }
        }
        return buyProduct;
    }

}
