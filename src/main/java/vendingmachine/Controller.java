package vendingmachine;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Change;
import vendingmachine.domain.Customer;
import vendingmachine.domain.Product;
import vendingmachine.domain.ProductList;
import vendingmachine.validator.InputValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
    private static final InputValidator inputValidator = new InputValidator();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private Change change;
    private Customer customer;
    private ProductList productList = new ProductList();

    public void run() {
        inputChange();
        inputProduct();
        inputMoney();
        System.out.println(productList.getMinimumPrice() + ", " + customer.getCustomerMoney());
        while (productList.getMinimumPrice() <= customer.getCustomerMoney()) {
            buyProduct();
        }
        returnChange();
    }

    // 1. 보유 잔돈  입력
    public void inputChange() {
        try{
            inputView.printInputChange();
            String inputChange = Console.readLine();
            int intChange = inputValidator.validateOnlyInteger(inputChange);
            inputValidator.isMultipleOfTen(intChange);
            change = new Change(intChange);
            outputView.printCoinList(change);
        }catch (IllegalArgumentException exception){
            outputView.printError(exception.getMessage());
            inputChange();
        }
    }

    // 2. 보유 상품 입력
    public void inputProduct() {
        inputView.printInputProducts();
        String products = Console.readLine();
        changeStringToProductList(products);
    }

    // 3. 투입 금액  입력
    public void inputMoney() {
        inputView.printInputMoney();
        String inputMoney = Console.readLine();
        int intMoney = Integer.parseInt(inputMoney);
        customer = new Customer(intMoney);
        outputView.printMoney(customer.getCustomerMoney());
    }

    // 4. 상품 구매
    public void buyProduct() {
        inputView.printInputBuyProduct();
        String productName = Console.readLine();
        Product product = productList.getProductByName(productName);
        customer.buyProduct(product);
        outputView.printMoney(customer.getCustomerMoney());
    }

    // 5. 잔돈 반환
    public void returnChange() {
        outputView.printChange(customer);
    }

    public void changeStringToProductList(String inputProduct) {
        String[] productList = inputProduct.split(";");
        for (String productInfo : productList) {
            changeStringToProductInformation(productInfo);
        }
    }

    public void changeStringToProductInformation(String productInfo) {
        productInfo = removeBracketInProduct(productInfo);
        String[] productInformation = productInfo.split(",");
        String name = productInformation[0];
        int price = Integer.parseInt(productInformation[1]);
        int amount = Integer.parseInt(productInformation[2]);
        Product product = new Product(name, price, amount);
        productList.addProductList(name, product);
    }

    private String removeBracketInProduct(String productInfo) {
        return productInfo.substring(1, productInfo.length() - 1);
    }
}
