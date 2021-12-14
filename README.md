# 3주차 미션 - 자판기

<br>

## 기능 목록

 - 최초 자판기 보유금 입력
    - 보유금으로 각 동전 개수를 랜덤 생성
    - 보유금은 10원으로 나누어 떨어지게 제한


 - 자판기 보유 동전의 수량을 출력하는 기능
 

 - 자판기의 상품을 추가하는 기능
   - 상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분하도록 제한
   - 상품명,가격,수량은 빈칸이 될 수 없게 제한(예외처리를 의미)
   - 상품명은 중복이 될 수 없게 제한
   - 가격과 수량은 문자가 아닌 양의 정수로 제한
   - 상품 가격은 최소 100원으로 제한
   - 상품 가격은 10원으로 나누어 떨어지게 제한
 

 - 금액을 투입 받는 기능
   - 입력 값이 0이상의 정수이고 10원으로 나누어 떨어지도록 제한


 - 상품을 구매하는 기능
   - 구매할 상품명을 입력 받음
   - 상품명에 빈 문자열은 제한
   - 상품명에 해당하는 상품이 있는지 확인하는 기능
   - 남은 투입 금액 이하의 상품만 구매 가능한 기능
   - 잔액이 최저 가격의 상품보다 작거나 구매가능한 상품이 없을때 잔액 반환


 - 잔돈 금액을 최소 개수의 동전으로 구하는 알고리즘 구현
   - 잔돈 반환이 불가능하면 반환 가능한 금액만 반환
 
<br>

## vendingmachine 패키기 구성

```
 constants
  - StringConstants.java
  
 servicesource
  - wallet
    - Coin.java
    - WalletSystem.java
    - WalletPrinter.java
    
  - MachineStock.java
  - Product.java
  - VendingMachine.java
  
 utils
  - datatypechecker
    - IntegerChecker.java
    - StringChecker.java
  
  - productchecker
    - InputChecker.java
    - NameChecker.java
    - PriceChecker.java
    - QuantityChecker.java
    
  - moneychecker
    - BalanceInputChecker.java
    - InsertMoneyChecker.java
    
  Application.java 
```


## 기능별 클래스 할당

- Product class
  - 이름, 가격 필드
  - getter 함수

- VendingMachine class 
  - 자판기를 작동시키는 함수
  - 상품을 판매하는 함수

- MachineStock class
  - 상품의 리스트와 재고를 저장하는 필드
  - 상품을 추가하는 함수
  - 입력된 상품이 존재하지 확인하는 함수
  - 상품의 재고를 확인하는 함수
  - 상품을 판매하여 재고를 조정하는 함수

- WalletSystem class
  - 자판기의 보유 잔액을 저장하는 필드
  - 투입받은 금액을 저장하는 필드
  - 동전을 Map으로 저장하는 필드
  - 입력 받은 보유금으로 랜덤한 동전을 생성하는 함수

- WalletPrinter class
  - 보유 중인 동전 정보를 출력하는 함수
  - 남은 투입 금액을 출력하는 함수
  - 잔돈을 반환하는 함수
    - 최소 개수로 반환하는 알고리즘 구현

- StringConstants class
  - 문자열 상수를 저장 

- StringChecker class
  - 문자열관련 확인 기능을 담당하는 클래스
  - parse 기능 함수
  - 같은 문자열이 리스트에 있는지 확인하는 함수

- IntegerChecker class
  - 정수관련 확인 기능을 담당하는 클래스

- InputChecker class
  - 상품을 입력 받고 올바른 예외처리
  - 세미콜론, 쉼표로 parse한 문자열을 각 형식에 맞게 검사를 진행

- NameChecker class
  - 상품의 이름이 올바른지 확인하는 함수
  - 중복된 이름이 있는지 확인하는 함수

- PriceChecker class
  - 상품의 가격이 올바른지 확인하는 함수

- QuantityChecker class
  - 상품의 수량이 올바른지 확인하는 함수

- BalanceInputChecker
  - 금액을 투입받는 함수
  - 자판기의 최초 보유 금액을 확인

- InsertMoneyChecker
  - 입력(투입)받은 금액을 확인하는 함수

