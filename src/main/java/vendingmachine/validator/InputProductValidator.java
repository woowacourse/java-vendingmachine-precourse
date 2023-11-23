package vendingmachine.validator;

import vendingmachine.domain.Product;

public class InputProductValidator {
    public static Product validateProduct(String product){
        String[] inputForm = validateInputForm(product);
        String name = validateName(inputForm[0]);
        int price = validatePrice(inputForm[1]);
        int quantity = validateQuantity(inputForm[2]);
        return new Product(name, price, quantity);
    }

    private static String[] validateInputForm(String product){
        String[] parts = product.replaceAll("[\\[\\]]", "").split(",");
        if(parts.length != 3)
            throw new IllegalArgumentException("[ERROR] 입력 서식이 올바르지 않습니다.");
        return parts;
    }

    private static String validateName(String name){
        validateSpace(name);
        return name;
    }
    private static int validatePrice(String price){
        int parsedPrice = 0;
        validateSpace(price);
        try{
            parsedPrice = Integer.parseInt(price);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 가격은 정수여야 합니다.");
        }
        validateMinimum(parsedPrice);
        validateNegativeOrZero(parsedPrice);
        validateUnit(parsedPrice);
        return parsedPrice;
    }

    private static int validateQuantity(String quantity){
        int parsedQuantity = 0;
        validateSpace(quantity);
        try{
            parsedQuantity = Integer.parseInt(quantity);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 수량은 정수여야 합니다.");
        }
        validateNegativeOrZero(parsedQuantity);
        return parsedQuantity;
    }
    private static void validateSpace(String input){
        if(input.contains(" ")){
            throw new IllegalArgumentException("[ERROR] 삼품명에 공백이 존재합니다.");
        }
    }

    private static void validateMinimum(int price){
        if(price < 100){
            throw new IllegalArgumentException("[ERROR] 상품 가격은 최소 100원 이상이여야 합니다.");
        }
    }
    private static void validateNegativeOrZero(int number){
        if(number <= 0){
            throw new IllegalArgumentException("[ERROR] 0 또는 음수는 입력될 수 없습니다.");
        }
    }

    private static void validateUnit(int price){
        if(price % 10 != 0){
            throw new IllegalArgumentException("[ERROR] 상품 가격은 10원 단위여야 합니다.");
        }
    }
}
