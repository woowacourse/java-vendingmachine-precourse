package vendingmachine.Controller;

import vendingmachine.Model.Product;
import vendingmachine.Validation.ValidationPurchase;
import vendingmachine.View.Input;
import vendingmachine.View.Output;

import java.util.List;

public class PurchaseController {
    private int userCoin;
    private List<Product> productList;
    private String purchase;

    public PurchaseController(int userCoin, List<Product> productList){
        this.userCoin = userCoin;
        this.productList = productList;
    }

    public int Purchase(){
        while(true){
            Output.MSGCurrentAmount(userCoin);
            if(!ValidationPurchase.isPurchase(userCoin, productList)){
                break;
            }
            Output.MSGInputPurchase();
            InputPurchase(Input.ConsoleInput());
            System.out.println();

            ChangeCoinProduct(purchase);
        }
        return userCoin;
    }

    public void InputPurchase(String purchaseInput) {
        try{
            ValidationPurchase.isContainProduct(productList, purchaseInput);
            ValidationPurchase.isSoldOut(productList, purchaseInput);
            purchase = purchaseInput;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            InputPurchase(Input.ConsoleInput());
        }
    }

    private void ChangeCoinProduct(String purchase){
        for(Product product : productList){
            if(product.getName().equals(purchase)){
                product.setCount(product.getCount() - 1);
                userCoin = userCoin- product.getPrice();
            }
        }

    }

}
