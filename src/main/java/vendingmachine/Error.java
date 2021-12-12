package vendingmachine;

public enum Error {
    COUNT_FORM("[ERROR] 상품 수량은 자연수로 입력해주세요."),
    AMOUNT_FORM("[ERROR] 가격(금액)은 10으로 나누어 떨어지는 자연수로 입력해주세요."),
    PRODUCT_INPUT_FORM("[ERROR] 상품 입력 형식에 맞게 입력해주세요."),
    PRODUCT_NON_EXIST("[ERROR] 존재하는 상품만 입력해주세요.");

    private String errorMessage;
    Error(String errorMessage){
        this.errorMessage=errorMessage;
    }

    public void generate(){
        System.out.println(this.errorMessage);
        throw new IllegalArgumentException();
    }
}
