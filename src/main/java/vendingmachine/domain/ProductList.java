package vendingmachine.domain;

import vendingmachine.domain.Product;
import vendingmachine.validator.Validator;
import vendingmachine.view.LoopInput;

import java.util.HashMap;

public class ProductList extends LoopInput {
    private static final String INSERT_PRODUCT_MESSAGE = "상품명과 가격, 수량을 입력해주세요.";
    private static final HashMap<String, Product> productMap = new HashMap<>();
    private static final HashMap<String, Product> productList = new HashMap<>();
    private static final Validator validator = new Validator();
    private static int minimumPrice = Integer.MAX_VALUE;

    // After
    public void addProductList(String productName, Product product) {
        productList.put(productName, product);
    }

    //After
    public HashMap<String, Product> getProductList() {
        return productList;
    }

    public void inputMethod() {
        this.inputProductList();
    }

    public boolean existProductName(String name) {
        return productMap.containsKey(name);
    }

    public Product sellProduct(String product) {
        Product sellProduct = productMap.get(product);
        validator.validateProductStock(sellProduct);
        sellProduct.sell();
        return sellProduct;
    }

    public boolean isAvailableProduct(String productName) {
        Product product = productMap.get(productName);
        return product.existStock();
    }

    private void initProductMap() {
        productMap.clear();
    }

    public boolean compareMinimumPrice(int customerMoney) {
        return customerMoney >= minimumPrice;
    }

    public boolean checkAvailableState(int customerMoney) {
        return checkProductStock() && compareMinimumPrice(customerMoney);
    }

    private void inputProductList() {
        String product = inputString(INSERT_PRODUCT_MESSAGE);
        initProductMap();
        String[] productList = validator.validateSplitRegex(product);
        setNumberOfProducts(productList);
    }

    private boolean checkProductStock() {
        for (String name : productMap.keySet()) {
            Product product = productMap.get(name);
            if (product.existStock()) {
                return true;
            }
        }
        return false;
    }

    private void setNumberOfProducts(String[] productInformationList) {
        for (String productInformation : productInformationList) {
            Product product = validator.validateSplitProductInformation(productMap, productInformation);
            compareMinimumPrice(product);
            productMap.put(product.getName(), product);
        }
    }

    private void compareMinimumPrice(Product product) {
        minimumPrice = product.isLessThanMinimumPrice(minimumPrice);
    }
}
