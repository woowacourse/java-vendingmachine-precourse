# 미션 - 자판기

## 📝 기능 목록

- 자판기 보유 금액 입력받기

  - 예외가 발생하면 "[ERROR]"로 시작하는 에러 메시지를 출력 후 자판기 보유 금액을 다시 입력받는다
  - (예외처리)
  - 아무것도 입력받지 않을 경우
  - 양의 정수가 아닐 경우
  - Integer.MAX_VALUE보다 큰 값을 입력할 경우
  - 가장 작은 코인의 금액으로 나눠지지 않을 경우
- 보유 금액으로 동전 생성하기
  - 동전의 종류는 500원, 100원, 50원, 10원으로 4개이다 
  - 보유 금액으로 동전을 무작위로 생성한다
  - 투입 금액으로는 동전을 생성하지 않는다
- 재고 설정하기
  - 상품명, 가격, 수량을 입력하여 상품을 추가한다
  - 개별 상품은 대괄호([])로 묶어 세미콜론;으로 구분한다
  - 상품 가격은 100원부터 시작하며, 10원으로 나누어 떨어져야 한다
  - 예외가 발생하면 "[ERROR]"로 시작하는 에러 메시지를 출력 후 자판기 상품을 다시 입력받는다
  - (예외처리)
  - 아무것도 입력받지 않을 경우
  - 입력에 공백이 있을 경우
  - 입력에 탭이 있을 경우
  - ;기준으로 나눴을 때 아무것도 없는 경우
  - ;기준으로 나눴을 때 개수가 Integer.MAX_VALUE보다 많은 경우
  - ;기준으로 나눴을 때 []로 감싸져 있지 않은 경우
  - ,기준으로 나눴을 때 개수가 Integer.MAX_VALUE보다 많은 경우
  - ,기준으로 나눴을 때 아무것도 없는 경우
  - ,기준으로 나눴을 때 개수가 3개가 아닌 경우
  - 상품명이 아무것도 입력받지 않을 경우
  - 상품명에 공백이 있을 경우
  - 상품명에 탭이 있을 경우
  - 동일한 상품명이 입력될 경우
  - 가격이 100원이 안 될 경우
  - 가격이 양의 정수가 아닐 경우
  - 가격이 Integer.MAX_VALUE보다 큰 경우
  - 가격이 가장 작은 코인의 금액으로 나눠지지 않을 경우
  - 수량이 양의 정수가 아닐 경우
  - 수량이 Integer.MAX_VALUE보다 큰 경우
- 투입 급액 입력받기
  - 예외가 발생하면 "[ERROR]"로 시작하는 에러 메시지를 출력 후 자판기 보유 금액을 다시 입력받는다
  - (예외처리)
  - 투입 금액이 양의 정수가 아닐 경우
  - 투입 금액이 Integer.MAX_VALUE보다 큰 경우
  - 투입 금액이 가장 작은 코인의 금액으로 나눠지지 않을 경우
- 상품 구매하기
  - 사용자가 투입한 금액으로 상품을 구매할 수 있다
  - 남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진되면 바로 잔돈을 돌려준다
  - 예외가 발생하면 "[ERROR]"로 시작하는 에러 메시지를 출력 후 자판기 보유 금액을 다시 입력받는다
  - (예외처리)
  - 상품명이 아무것도 입력받지 않을 경우
  - 상품명에 공백이 있을 경우
  - 상품명에 탭이 있을 경우
  - 해당 상품이 없을 경우
  - 잔액보다 더 큰 상품을 선택한 경우
- 잔돈을 돌려준다
  - 현재 보유한 최소 개수의 동전으로 돌려준다
  - 지폐를 잔돈으로 반환하지 않는다
<br>

## 📝 프로젝트 구조

````
│  .editorconfig
│  .gitignore
│  build.gradle
│  gradle.properties
│  gradlew
│  gradlew.bat
│  naver-checkstyle-rules.xml
│  naver-intellij-formatter.xml
│  README.md
│  settings.gradle
│
├─docs
│      README.md
│
└─src
    ├─main
    │  └─java
    │      └─vendingmachine
    │          │  Application.java
    │          │
    │          ├─constant
    │          │      Message.java
    │          │      Rule.java
    │          │
    │          ├─controller
    │          │      VendingMachineController.java
    │          │
    │          ├─model
    │          │      Change.java
    │          │      Coin.java
    │          │      HoldingSum.java
    │          │      InsertingSum.java
    │          │      Name.java
    │          │      Price.java
    │          │      Product.java
    │          │      Stock.java
    │          │      TheNumber.java
    │          │      VendingMachine.java
    │          │
    │          ├─service
    │          │      VendingMachineService.java
    │          │
    │          ├─util
    │          │      NumberChecker.java
    │          │      SplitChecker.java
    │          │      StringChecker.java
    │          │
    │          └─view
    │                  ChangeView.java
    │                  HoldingSumView.java
    │                  InsertingSumView.java
    │                  NameView.java
    │                  StockView.java
    │
    └─test
        └─java
            └─vendingmachine
                    ApplicationTest.java
````

## 📝 클래스 구조 및 역할

- Controller
  - 자판기 동작 순서 제어 역할
    - 자판기 동작 순서
      - 자판기 보유 금액 입력받기
      - 보유 금액 출력하기
      - 재고 설정하기
      - 투입 금액 입력받기
      - 상품 판매하기
      - 잔돈 출력하기
- Service
  - 자판기 기능 비즈니스 로직 구현 역할
    - 상품 판매하기
- View
  - 사용자에게 보여지는 UI 로직 구현 역할
    - 자판기 보유 금액 입력받기
    - 보유 동전 출력하기
    - 재고 입력받기
    - 투입 금액 입력받기
    - 구매 상품 입력받기
    - 잔돈 출력하기
- Model
  - 비즈니스 로직에 사용되는 객체 모음
    - VendingMachine
      - HoldingSum
        - Coin
      - Stock
        - Product
          - Name
          - Price
          - TheNumber
      - InsertingSum
    - Change
      - Coin
- Constant
  - 자판기에서 사용되는 상수 모음
    - Message
    - Rule
<br>

---

## 📝 License

This project is [MIT](https://github.com/woowacourse/java-baseball-precourse/blob/master/LICENSE) licensed.
