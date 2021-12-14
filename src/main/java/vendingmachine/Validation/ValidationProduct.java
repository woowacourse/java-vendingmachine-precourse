package vendingmachine.Validation;

public class ValidationProduct {
    public static void isBracket(String product) {
        if (product.charAt(0) != '[' || product.charAt(product.length() - 1) != ']') {
            throw new IllegalArgumentException("[ERROR] 대괄호가 필요합니다.");
        }
    }

    public static void isProduct(String[] productInfo){
        ValidationProduct.isPrice(productInfo[1]);
        ValidationProduct.isCount(productInfo[2]);
    }

    private static void isPrice(String price){
        isIntegerPrice(price);
        isPrice100(price);
        isDividePrice(price);
    }

    private static void isIntegerPrice(String price){
        try{
            Integer.parseInt(price);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    private static void isPrice100(String price){
        if(Integer.parseInt(price) < 100){
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100원부터 시작해야 합니다.");
        }
    }

    private static void isDividePrice(String price){
        if(Integer.parseInt(price)%10 != 0){
            throw new IllegalArgumentException("[ERROR] 상품 가격은 10원으로 나누어떨어져야 합니다.");
        }
    }

    private static void isCount(String count){
        isIntegerCount(count);
        isProductCount(count);
    }

    private static void isIntegerCount(String count){
        try{
            Integer.parseInt(count);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    private static void isProductCount(String count){
        if(Integer.parseInt(count) <= 0){
            throw new IllegalArgumentException("[ERROR] 상품 수량은 1개 이상이어야 합니다.");
        }
    }

}
