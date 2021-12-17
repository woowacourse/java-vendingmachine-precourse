package vendingmachine.domain;

import vendingmachine.validator.ValidatorOld;
import vendingmachine.view.LoopInput;

import java.util.HashMap;

public class ProductList extends LoopInput {
    private static final HashMap<String, Product> productList = new HashMap<>();
    private static int minimumPrice = Integer.MAX_VALUE;

    // After
    public void addProductList(String productName, Product product) {
        productList.put(productName, product);
        minimumPrice = product.isLessThanMinimumPrice(minimumPrice);
    }
    public void initProductMap() {
        productList.clear();
    }
    //After
    public HashMap<String, Product> getProductList() {
        return productList;
    }

    public Product getProductByName(String name) {
        return productList.get(name);
    }
    public int getMinimumPrice(){
        return minimumPrice;
    }

    public boolean checkAvailableState(int customerMoney) {
        return checkProductStock() && compareMinimumPrice(customerMoney);
    }
    public boolean compareMinimumPrice(int customerMoney) {
        return customerMoney >= minimumPrice;
    }
    private boolean checkProductStock() {
        for (String name : productList.keySet()) {
            Product product = productList.get(name);
            if (product.existStock()) {
                return true;
            }
        }
        return false;
    }
    /******************************************************************/
    private static final String INSERT_PRODUCT_MESSAGE = "상품명과 가격, 수량을 입력해주세요.";
    private static final HashMap<String, Product> productMap = new HashMap<>();
    private static final ValidatorOld VALIDATOR_OLD = new ValidatorOld();


    public void inputMethod() {
        this.inputProductList();
    }

    public boolean existProductName(String name) {
        return productMap.containsKey(name);
    }

    public Product sellProduct(String product) {
        Product sellProduct = productMap.get(product);
        VALIDATOR_OLD.validateProductStock(sellProduct);
        sellProduct.sell();
        return sellProduct;
    }

    public boolean isAvailableProduct(String productName) {
        Product product = productMap.get(productName);
        return product.existStock();
    }






    private void inputProductList() {
        String product = inputString(INSERT_PRODUCT_MESSAGE);
        initProductMap();
        String[] productList = VALIDATOR_OLD.validateSplitRegex(product);
        setNumberOfProducts(productList);
    }



    private void setNumberOfProducts(String[] productInformationList) {
        for (String productInformation : productInformationList) {
            Product product = VALIDATOR_OLD.validateSplitProductInformation(productMap, productInformation);
            compareMinimumPrice(product);
            productMap.put(product.getName(), product);
        }
    }

    private void compareMinimumPrice(Product product) {
        minimumPrice = product.isLessThanMinimumPrice(minimumPrice);
    }
}
