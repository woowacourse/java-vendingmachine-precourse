package vendingmachine.view;

public class ProductInputView {
    private static final String INSERT_PRODUCT_MESSAGE = "상품명과 가격, 수량을 입력해주세요.";

    public void printInputProduct(){
        System.out.println(INSERT_PRODUCT_MESSAGE);
    }
}
