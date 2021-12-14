package vendingmachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 자판기의 돈 입력
        Vendingmachine vendingmachine = new Vendingmachine();
        vendingmachine.inputVendMoney();
        vendingmachine.getVendMoney();

        // 자판기의 돈을 동전으로 바꿈
        vendingmachine.getVendMoneyToCoin();
        vendingmachine.printRandomCoin();

        // 상품 입력
        vendingmachine.prodInput();
        
        // 사용자의 돈 입력
        vendingmachine.userMoneyInput();

        // 구매
        vendingmachine.play();
        vendingmachine.printLastMoney();
    }
}
