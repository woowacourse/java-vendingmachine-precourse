# 미션 - 자판기

## 기능 구현 목록

- [x] 자판기가 보유하고 있는 금액으로 동전을 무작위로 생성하기
    - [x] 자판기 보유금액 입력받기 InputView#getMoney
    - [x] 금액 예외처리 InputView#checkMoneyValidation
    - [x] 보유 금액으로 동전 랜덤 생성하기 VendingMachine#generateCoins
        - [x] 투입 금액으로는 동전을 생성하지 않기
- [x] 상품명, 가격, 수량을 입력하여 상품을 추가하기
    - [x] 상품명, 가격, 수량을 입력받는 기능 InputView#getProducts
    - [x] 상품정보 예외처리 기능 InputView#checkProductsValidation
        - [x] 공백입력검사 Validators#checkNullOrEmpty
        - [x] 상품정보 패턴 검사 Validators#checkPatternOfProduct
            - [x] 특정 패턴이 맞는지
            - [x] 상품 이름을 중복해서 입력 방지하기
            - [x] 상품 가격은 100원부터 시작하며, 10원으로 나누어떨어지도록 예외처리하기
            - [x] 상품 갯수는 1개이상을 입력하기
    - [x] 입력받은 정보를 상품으로 추가하기 VendingMachine#insertProducts
- [x] 사용자가 투입한 금액으로 상품을 구매하기
    - [x] 사용자 투입 금액 입력받기 InputView#getMoney
    - [x] 구매할 상품 입력 받기 InputView#getProductName
        - [x] 존재하는 상품인지 검증 하기 Validators#checkValidProduct
        - [x] 해당 상품의 갯수가 1개이상인지 검증 하기
        - [x] 보유 중인 금액이 상품 금액보다 크거나 같은지 검증 하기
    - [x] 상품 구매하기 VendingMachine#sale
- [x] 남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려주기 Controller
    - [x] 특정조건(최저가격보다 금액이 낮거나, 상품이 비었거나)에서 상품구매 종료하는 반복문 구현 VendingMachine#canSale
    - [x] 잔돈 반환하기 VendingMachine#returnCoins
        - [x] 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환하기
        - [x] 잔돈을 돌려줄 때 현재 보유한 최소 개수의 동전으로 돌려주기
        - [x] 반환된 동전만 출력하기 CoinCounter#toString
        - [x] 반환되지 않은 금액은 자판기에 남기기
        - 지폐를 잔돈으로 반환하는 경우는 없다고 가정
- [x] 예외처리
    - [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생 Validators
    - [x] "[ERROR]"로 시작하는 에러 메시지를 출력 후 해당 부분부터 다시 입력을 받기 InputView

## 입출력 예시

```
자판기가 보유하고 있는 금액을 입력해 주세요.
450

자판기가 보유한 동전
500원 - 0개
100원 - 4개
50원 - 1개
10원 - 0개

상품명과 가격, 수량을 입력해 주세요.
[콜라,1500,20];[사이다,1000,10]

투입 금액을 입력해 주세요.
3000

투입 금액: 3000원
구매할 상품명을 입력해 주세요.
콜라

투입 금액: 1500원
구매할 상품명을 입력해 주세요.
사이다

투입 금액: 500원
잔돈
100원 - 4개
50원 - 1개
```

---
