package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {
    int sumCoin = 0;

    public int getCoin(){
        return sumCoin;
    }
    public void setCoin(int coin){
        this.sumCoin = coin;
    }

    public void InputMachineCoin(){
        String machineCoinString = Console.readLine();
        try{
            isInteger(machineCoinString);
            isPositiveCoin(machineCoinString);
            isDivideCoin(machineCoinString);
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            InputMachineCoin();
        }
        setCoin(Integer.parseInt(machineCoinString));
    }

    public void InputProduct(){
        String productListString = Console.readLine();
        List<Product> productList = new ArrayList<>();
        String[] products = productListString.split(";");
        for(String product : products){
            try{
                isBracket(product);
                product = product.substring(1, product.length()-1);
                String[] productInfo = product.split(",");
                isIntegerPrice(productInfo[1]);
                isDividePrice(productInfo[1]);
                isPrice100(productInfo[1]);
                isIntegerCount(productInfo[2]);
                Product newProduct = new Product(productInfo[0], Integer.parseInt(productInfo[1]), Integer.parseInt(productInfo[2]));
                productList.add(newProduct);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                InputProduct();
            }
        }
        for(Product product : productList){
            System.out.println(product.getName() + ", " + product.getPrice() + ", " + product.getCount());
        }

    }

    private void isInteger(String machineCoinString){
        try{
            Integer.parseInt(machineCoinString);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    private void isPositiveCoin(String machineCoinString){
        if(Integer.parseInt(machineCoinString) < 0){
            throw new IllegalArgumentException("[ERROR] 금액은 0이상이어야 합니다.");
        }
    }

    private void isDivideCoin(String machineCoinString){
        if(Integer.parseInt(machineCoinString)%10 != 0){
            throw new IllegalArgumentException("[ERROR] 금액은 10원으로 나누어떨어져야 합니다.");
        }
    }

    private void isBracket(String product) {
        if (product.charAt(0) != '[' || product.charAt(product.length() - 1) != ']') {
            throw new IllegalArgumentException("[ERROR] 대괄호가 필요합니다.");
        }
    }

    private void isPrice100(String price){
        if(Integer.parseInt(price) < 100){
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100원부터 시작해야 합니다.");
        }
    }

    private void isDividePrice(String price){
        if(Integer.parseInt(price)%10 != 0){
            throw new IllegalArgumentException("[ERROR] 상품 가격은 10원으로 나누어떨어져야 합니다.");
        }
    }

    private void isProductCount(String count){
        if(Integer.parseInt(count) <= 0){
            throw new IllegalArgumentException("[ERROR] 상품 수량은 1개 이상이어야 합니다.");
        }
    }

    private void isIntegerPrice(String price){
        try{
            Integer.parseInt(price);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }

    private void isIntegerCount(String count){
        try{
            Integer.parseInt(count);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.");
        }
    }
}