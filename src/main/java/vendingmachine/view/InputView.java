package vendingmachine.view;

public class InputView {
    private static void isValidPrice(int price){
        if (price%10!=0){
            throw new IllegalArgumentException();
        }
    }
    public static int parseInt(String input) {
        isInteger(input);
        int result = Integer.parseInt(input);
        isPositive(result);
        isValidPrice(result);
        return result;
    }

    public static int parseOnlyInt(String input) {
        isInteger(input);
        int result = Integer.parseInt(input);
        isPositive(result);
        return result;
    }

    private static void isPositive(int input) {
        if (input < 1) {
            throw new IllegalArgumentException();
        }
    }

    private static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static String[] splitString(String input) {
        String[] result = input.split(";");
        isValidProduct(result);
        return result;
    }

    private static void isValidProduct(String[] result) {
        for(String product : result){
            if (countChar(product,',')>2){
                throw new IllegalArgumentException();
            }
            if (product.charAt(0)!='[' || product.charAt(product.length()-1)!=']'){
                throw new IllegalArgumentException();
            }
            product = product.substring(1, product.length() - 1);
            String[] productInfo = product.split(",");
            int productPrice = parseInt(productInfo[1]);
            int productNum = parseOnlyInt(productInfo[2]);
        }
    }

    private static int countChar(String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
