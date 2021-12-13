package vendingmachine;

public class Validator {
    public Validator(){

    }
    public void validateAmount(String amount){
        int parsedAmount = -1;
        try {
            parsedAmount = Integer.parseInt(amount);
        }catch (Exception e){
            System.out.println("[ERROR] 정수로 입력 해주세요");
            throw new IllegalArgumentException();
        }
        if(parsedAmount < 10) {
            System.out.println("[ERROR] 10보다 큰 수를 입력해 주세요");
            throw new IllegalArgumentException();
        }
        if(parsedAmount % 10 !=0) {
            System.out.println("[ERROR] 10으로 나누어 떨어지는 수를 입력해 주세요");
            throw new IllegalArgumentException();
        }
    }
}
