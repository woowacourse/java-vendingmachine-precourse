package vendingmachine.Validation;

import vendingmachine.Model.Product;

import java.util.List;

public class ValidationPurchase {
    public static Boolean isPurchase(int userCoin, List<Product> productList){
        for(Product product : productList){
            if(product.getCount() > 0 && userCoin >= product.getPrice()){
                return true;
            }
        }
        return false;
    }
    public static void isContainProduct(List<Product> productList, String purchase){
        boolean existProduct = false;
        for(Product product :productList){
            if(product.getName().equals(purchase)){
                existProduct = true;
                break;
            }
        }
        if(!existProduct)
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다.");
    }

    public static void isSoldOut(List<Product> productList, String purchase){
        for(Product product : productList){
            if(product.getName().equals(purchase)){
                if(product.getCount() == 0) {
                    throw new IllegalArgumentException("[ERROR] 상품이 소진되었습니다.");
                }
            }
        }
    }
}
