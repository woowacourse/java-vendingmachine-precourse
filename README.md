# 미션 - 자판기 🥫

: [Java 8](https://www.oracle.com/java/technologies/java8.html) 환경에서 빈환하는 잔돈의 동전이 최소한이 되는 자판기를 구현하는 프로그램 

## ✍🏻 기능 목록
 1. 자판기가 보유하고 있는 금액을 입력받기 
     - 자판기가 보유하고 있는 금액으로 동전을 무작위로 생성한다.
     

 2. 자판기가 보유한 동전 출력하기
    

 3. 상품명과 가격, 수량 입력받기 
    - 상품 가격은 100원 이상이고 10원으로 나누어 떨어져야 한다.
    - 상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분한다.
     

 4. 사용자에게 투입 금액 입력받기. 
    - 투입한 금액으로 상품을 구매할 수 있다. 
    - 투입 금액으로는 동전을 생성하지 않는다.
     

 5. 구매할 상품명 입력받기 
    - 해당 상품을 구매할 수 없는 경우 다시 구매할 상품명을 입력받는다. 
     

 6. 잔돈 출력하기 
    - 잔돈은 반환된 동전만 출력한다. 
    - 남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다.
    - 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다. 
    - 현재 자판기가 보유한 최소 개수의 동전으로 잔돈을 돌려준다.
 
 #### [예외 상황]      
- 자판기 금액이 자연수가 아닌 경우.   
  : **[ERROR] 금액은 자연수여야 합니다.**  
    

- 자판기 금액이 빈 값인 경우.   
 : **[ERROR] 입력 값은 빈 값일 수 없습니다.**  
  

- 자판기 금액이 10으로 나누어 떨어지지 않는 경우.   
  : **[ERROR] 금액은 10으로 나누어 떨어져야 합니다.**
  

- 상품이 빈 값으로 입력 되는 경우.   
  : **[ERROR] 입력 값은 빈 값일 수 없습니다.**
  

- 상품이 형식에 맞게 들어오지 않는 경우.   
  : **[ERROR] 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해야 함니다.**
  

- 상품의 길이가 3(상품명, 가격, 수량)이 아니고 빈 값이 있을 경우.  
  : **[ERROR] 상품명, 가격, 수량은 쉼표로, 구분하여 상품명, 가격, 수량 3개의 정보가 입력되어야 합니다.**
  

- 상품 가격이 100이상 자연수가 아닌 경우.   
 : **[ERROR] 상품 가격은 100이상의 자연수 여야 합니다.**
  

- 상품 가격이 10으로 나누어 떨어지지 않는 경우.   
  : **[ERROR] 상품 가격은 10으로 나누어 떨어져야 합니다.**
  

- 상품 수량이 자연수가 아닐 경우.   
  : **[ERROR] 상품 수량은 자연수여야 합니다.**
  

- 상품이 중복되게 들어오는 경우.   
  : **[ERROR] 상품은 중복돼서 들어올 수 없습니다.**
  

- 투입 금액이 빈 값인 경우.   
  : **[ERROR] 입력 값은 빈 값일 수 없습니다.**
  

- 투입 금액이 자연수가 아닌 경우.   
  : **[ERROR] 금액은 자연수여야 합니다.**
  

- 투입 금액이 10으로 나누어 떨어지지 않는 경우.   
  : **[ERROR] 금액은 10으로 나누어 떨어져야 합니다.**
  

- 구매할 상품명이 목록에 없을 경우.  
  : **[ERROR] 상품 목록에 없는 상품입니다.**


#### 💻 프로그래밍 실행 결과 예시

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

## 📒 패키지 구조
* main/java/vendingmachine
    * controller
        * VendingMachineController.java
    * domain
        * enumclass
          * Coin.java
        * Product.java
        * VendingMachine.java
    * exception
        * dto
            * ErrorResponse.java
        * ErrorMessage.java
    * message
        * dto
            * ResponseMessage.java
        * Message.java
    * service
        * VendingMachineService.java
    * utils
      * ChangeUtil.java
      * CoinUtil.java
    * validation
        * enumclass
          * Constant.java
        * validator
          * InputCostValidator.java
          * InputProductNameValidator.java
          * InputProductsValidator.java
          * InputProductValidator.java
          * InputVendingMachineCostValidator.java
        * GlobalValidation.java
    * VendingMachineClient.java
    * Application.java


## ✔️ Commit Conventions
- **feat**: 기능 추가 관련 커밋
- **fix**: 버그 수정 관련 커밋
- **docs**: 문서 관련 커밋
- **refactor**: 코드 수정 관련 커밋
- **test**: 테스트 관련 커밋


## 💻 Test

Mac or Linux

```bash
./gradlew clean test
```

Windows

```bash
gradlew.bat clean test
```
