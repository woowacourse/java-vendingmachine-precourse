package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import static vendingmachine.Validation.VALIDATION_SUCCESS;

public class User {
    private int userOwnMoney;

    public User(){
        VALIDATION_SUCCESS = true;
        while(VALIDATION_SUCCESS){
            try{
                View.inputMsgOnUser();
                String userOwnMoney = Console.readLine();
                Validation.userMoneyValidation(userOwnMoney);
                VALIDATION_SUCCESS = false;
                this.userOwnMoney = Integer.parseInt(userOwnMoney);
            }catch (IllegalArgumentException e){
                View.noticeMsgOnException(e.getMessage());
            }
        }
    } // 생성자 종료

    public int getUserOwnMoney(){
        return this.userOwnMoney;
    }

    public void minusUserOwnMoney(int moneyForMinus){
        this.userOwnMoney -= moneyForMinus;
    }

    public void purchaseProduct(ArrayList<Product> productList) throws IllegalArgumentException {
        View.inputMsgOnPurchaseProduct();
        String selectedProduct = Console.readLine();

        Product purchaseProduct = VendingMachine.isSelectedProductInVendingMachine(productList, selectedProduct);
        Validation.productNotFound(purchaseProduct);
        Validation.productAmountNotEnough(purchaseProduct);
        Validation.userMoneyNotEnough(purchaseProduct, this.userOwnMoney);
        purchaseProduct.sold();
        this.userOwnMoney -= purchaseProduct.getPrice();
    }
}
