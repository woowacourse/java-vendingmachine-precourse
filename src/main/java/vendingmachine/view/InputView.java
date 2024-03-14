package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class InputView {
    private InputView() {
    }

    public static int inputInitialMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String inputString = Console.readLine();
        validateNatural(inputString);
        validateTensMultiple(inputString);
        return Integer.parseInt(inputString);
    }

    public static Products inputInitialProducts() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        String inputString = Console.readLine();
        validateProductInput(inputString);
        Set<Product> generatedProducts = parseProductInput(inputString);
        return new Products(generatedProducts);
    }

    public static void validateNatural(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 정수여야 한다.");
        }

        int inputValue = Integer.parseInt(input);
        if(inputValue<1) throw new IllegalArgumentException("[ERROR] 입력값은 자연수여야 한다.");
    }

    public static void validateTensMultiple(String inputString) {
        int inputValue = Integer.parseInt(inputString);
        if(inputValue%10 == 0) return;
        throw new IllegalArgumentException("[ERROR] 입력값은 10의 배수여야 한다.");
    }

    public static void validateBiggerThanHundred(String inputString) {
        int inputValue = Integer.parseInt(inputString);
        if(inputValue<100) throw new IllegalArgumentException("[ERROR] 상품 가격은 100 이상이어야 한다.");
    }

    public static void validateProductInputRegex(String inputString) {
        String[] strings = inputString.split(";");
        String pattern = "[\\[]+[\\S*$]+[,]+[0-9*$]+[,]+[0-9*$]+[\\]]";
        boolean isNotValid = false;
        for(String s : strings){
            if(s.matches(pattern)) continue;
            isNotValid = true;
            break;
        }
        if(isNotValid) throw new IllegalArgumentException("[ERROR] 상품정보 입력값의 형식이 올바르지 않다.");
    }

    public static void validateProductInput(String inputString) {
        validateProductInputRegex(inputString);
        String[] strings = inputString.split(";");
        for(String s : strings) {
            String newString = s.replaceAll("[[\\[]|[\\]]]", "");
            String[] values = newString.split(",");
            validateTensMultiple(values[1]);
            validateBiggerThanHundred(values[1]);
        }
    }

    public static Set<Product> parseProductInput(String inputString) {
        Set<Product> products = new HashSet<>();
        String[] strings = inputString.split(";");
        for(String s : strings) {
            String newString = s.replaceAll("[[\\[]|[\\]]]", "");
            String[] values = newString.split(",");
            String productName = values[0];
            int productCost = Integer.parseInt(values[1]);
            int productCount = Integer.parseInt(values[2]);
            products.add(new Product(productName, productCost, productCount));
        }
        return products;
    }
}
