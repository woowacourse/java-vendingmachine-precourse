package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Change;
import vendingmachine.domain.Product;
import vendingmachine.util.Message;
import vendingmachine.validate.Validator;

import java.util.ArrayList;
import java.util.List;

import static vendingmachine.validate.Validator.*;

public class View {
    Validator validate = new Validator();
    public void printAskInputChange(){
        System.out.println(Message.MACHINE_CHANGE.getMessage());
    }
    public Change inputChange(){
        printAskInputChange();
        Change change;
        String inputChange = Console.readLine();
        try{
            validate.inputDigitalValidator(inputChange);
            change = new Change(Integer.parseInt(inputChange));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputChange();
        }
        return change;
    }

    public void printAskProducts(){
        System.out.println(Message.PRODUCT_LIST.getMessage());
    }

    public List<Product> inputProducts(){
        printAskProducts();
        String inputProducts = Console.readLine();
        List<Product> productsMaker;
        try {
            productsMaker = new ArrayList<>();
            addProduct(inputProducts, productsMaker);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputProducts();
        }
        return  productsMaker;
    }
    private void addProduct(String inputProducts, List<Product> productsMaker){
        String[] products = inputProducts.split(";");
        for (String product : products) {
            validate.productFormatValidator(product);
            validate.productInputSizeValidator(product);
            String[] productValue = product.split(",");
            validate.inputDigitalValidator(productValue[1]);
            validate.inputDigitalValidator(productValue[2]);
            validate.productCountValidator(productValue[2]);
            productsMaker.add(new Product(productValue[0], Integer.parseInt(productValue[1]), Integer.parseInt(productValue[2])));
        }
    }
}
