package vendingmachine.domain;

import java.util.List;

public class Products {
    private final List<Product> products;
    private final int minAmount;
    private final static int RUN_OUT = -1;

    public Products(List<Product> products, int minAmount) {
        this.products = products;
        this.minAmount = minAmount;
    }

    public int buy(String buyProduct) {
        int buyPrice = 0;
        for(int index = 0 ; index < products.size();index++){
            int buy =  products.get(index).buyProduct(buyProduct);
            if(buy!=RUN_OUT){
                buyPrice = buy;
            }
        }
        if(buyPrice == 0)throw new IllegalArgumentException("[ERROR] 해당 제품이 존재하지 않습니다.");
        return buyPrice;
    }
    public boolean checkContinue(int amount){
        if(minAmount > amount) return false;
        for(int index = 0; index < products.size(); index++){
            if(!products.get(index).isExistProduct())return false;
        }
        return true;
    }
}
