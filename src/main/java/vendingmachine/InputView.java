package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class InputView {

    private static final String MONEY_INPUT_INSTRUCTION = "자판기가 보유하고 있는 금액을 입력해 주세요. ";
    private static final String PRODUCT_INPUT_INSTRUCTION = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String ERROR_HEADER = "[ERROR] ";
    private static final String INCLUDE_SPACE_ERROR = "입력에 공백이 있습니다. 공백없이 입력해주세요. ";
    private static final String NOT_VALID_TYPE_MESSAGE = "올바른 숫자 형식이 아닙니다. 숫자를 입력해주세요. ";
    private static final String NOT_VALID_NUMBER_MESSAGE = "10원으로 나누어 떨어지는 금액을 입력해주세요. ";
    private static final String NOT_VALID_FORMAT_MESSAGE = "올바른 상품 입력 형식이 아닙니다. [상품명,가격,수량] 형식으로 입력해주세요.";


    public int inputMoney() {
        while (true) {
            try {
                System.out.println(MONEY_INPUT_INSTRUCTION);
                String inputMoney = Console.readLine();
                return checkValidMoney(inputMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(ERROR_HEADER + e.getMessage());
            }
        }
    }

    public Collection<Product> inputProduct() {
        while (true) {
            try {
                System.out.println(PRODUCT_INPUT_INSTRUCTION);
                String inputProducts = Console.readLine();
                return checkValidProducts(inputProducts);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(ERROR_HEADER + e.getMessage());
            }
        }

    }


    private int checkValidMoney(String inputValue) {

        if (!checkValidNumber(inputValue)) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_VALID_TYPE_MESSAGE);
        }
        int money = Integer.parseInt(inputValue);

        if (money % 10 != 0) {
            throw new IllegalArgumentException(ERROR_HEADER + NOT_VALID_NUMBER_MESSAGE);
        }

        return money;

    }

    private boolean checkValidNumber(String input) {
        if (input.matches("[0-9]+")) {
            return true;
        }
        return false;
    }

    private Collection<Product> checkValidProducts(String inputProducts) {
        Collection<Product> productList = new ArrayList<>();
        if (inputProducts.contains(" ")) {
            throw new IllegalArgumentException(ERROR_HEADER + INCLUDE_SPACE_ERROR);
        }
        for (String product : inputProducts.split(";")) {
            if (product.charAt(0) != '[' || product.charAt(product.length() - 1) != ']') {
                throw new IllegalArgumentException(ERROR_HEADER + NOT_VALID_FORMAT_MESSAGE);
            }
            productList.add(checkValidOneProduct(product));
        }
        return productList;
    }

    private Product checkValidOneProduct(String productString) {
        String productName;
        int proudctCount;
        int productPrice;
        productString = productString.replace("[", "");
        productString = productString.replace("]", "");
        String[] productInfo = productString.split(",");
        productName = productInfo[0];
        productPrice = checkValidMoney(productInfo[1]);
        proudctCount = Integer.valueOf(productInfo[2]);
        return new Product(productName, productPrice, proudctCount);
    }
}
