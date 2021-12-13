package vendingmachine;

import userInterface.CoinListManager;

public class Application {
    public static void main(String[] args) {
        /* TODO : 프로그램 구현
         * 1. 동전 리스트 생성 (입력 받기 -> 에러체크 넘을때까지 반복 -> 생성)
         * 2. 동전 리스트 + 개수별 출력
         * 3. 상품 리스트 생성 (입력 받기 -> 에러체크 넘을때까지 반복 -> 생성)
         * 4. 투입 금액 (입력 받기 -> 에러체크 넘을때까지 반복 -> 생성)
         * 5. 자판기 돌리기 (남은금액 계산 -> 주문받기(에러체크->반복) -> 잔고 출력)
         * 6. 잔여 금액 반환(출력)
         */
        Coins coinList = new Coins();
        CoinListManager coinListManager = new CoinListManager(coinList);
        coinListManager.makeRandomList();
        coinListManager.printCoinList();
    }
}
