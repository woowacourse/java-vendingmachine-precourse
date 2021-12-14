package vendingmachine.Controller;

import vendingmachine.Model.Coin;
import vendingmachine.Model.MachineCoin;
import static vendingmachine.Validation.ValidationVendingMachineCoin.*;

import vendingmachine.Model.Product;
import vendingmachine.Validation.ValidationProduct;
import vendingmachine.Validation.ValidationUserCoin;
import vendingmachine.Validation.ValidationVendingMachineCoin;
import vendingmachine.View.Output;
import vendingmachine.View.Input;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainController {
    int sumCoin;
    List<Product> productList = new ArrayList<>();
    int userCoin;
    MachineCoin machineCoin = new MachineCoin();
    Map<Coin, Integer> changes = new LinkedHashMap<>();

    public void VendingMachine(){
        Output.MSGInputMachineCoin();
        InputVendingMachineCoin(Input.ConsoleInput());

        VendingMachineCoinRandom();

        Output.MSGInputProduct();
        InputProduct(Input.ConsoleInput());
        System.out.println();

        Output.MSGInputAmount();
        InputUserCoin(Input.ConsoleInput());

        PurchaseController purchaseController = new PurchaseController(userCoin, productList);
        userCoin = purchaseController.Purchase();

        OutputChanges();

    }

    private void InputVendingMachineCoin(String machineCoinString){
        try{
            ValidationVendingMachineCoin.isInteger(machineCoinString);
            ValidationVendingMachineCoin.isPositiveCoin(machineCoinString);
            ValidationVendingMachineCoin.isDivideCoin(machineCoinString);
            sumCoin = Integer.parseInt(machineCoinString);
            System.out.println();
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            InputVendingMachineCoin(Input.ConsoleInput());
        }
    }

    private void VendingMachineCoinRandom(){
        machineCoin.CreateRandomCoin(sumCoin);
        Output.PrintMachineCoin(machineCoin);
        System.out.println();
    }

    private void InputProduct(String productListString){
        String[] products = productListString.split(";");
        for(String product : products){
            try{
                ValidationProduct.isBracket(product);
                product = product.substring(1, product.length()-1);
                String[] productInfo = product.split(",");
                ValidationProduct.isProduct(productInfo);
                CreateProduct(productInfo);
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                InputProduct(Input.ConsoleInput());
            }
        }
    }

    private void CreateProduct(String[] productInfo){
        Product newProduct = new Product(productInfo[0], Integer.parseInt(productInfo[1]), Integer.parseInt(productInfo[2]));
        productList.add(newProduct);
    }

    private void InputUserCoin(String userCoinString){
        try{
            ValidationUserCoin.isIntegerAmount(userCoinString);
            userCoin = Integer.parseInt(userCoinString);
            System.out.println();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            InputUserCoin(Input.ConsoleInput());
        }
    }

    public void OutputChanges(){
        Output.MSGChanges();

        initSettingChanges();

        ChangesCoin();

        Output.PrintChanges(changes);
    }

    public void initSettingChanges(){
        for(Coin coin : Coin.values()){
            changes.put(coin, 0);
        }
    }

    public void ChangesCoin(){
        Map<Coin, Integer> machineCoinMap = machineCoin.getMachineCoin();
        for(Map.Entry<Coin, Integer> m : machineCoinMap.entrySet()){
            if(m.getValue() == 0) {
                continue;
            }
            while(userCoin - m.getKey().getAmount() >= 0){
                userCoin = userCoin - m.getKey().getAmount();
                m.setValue(m.getValue() -1);
                changes.put(m.getKey(), changes.get(m.getKey())+1);
                if(m.getValue() == 0){
                    break;
                }
            }
        }
    }

}
