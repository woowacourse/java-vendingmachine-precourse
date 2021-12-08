# 미션 - 자판기

## ✍️ 구현할 기능

### Domain

------------

### ✅ VendingMachine
#### package java.vendingmachine.domain

- 현재 보유중인 잔돈
- 현재 보유중인 음료
- 현재 투입된 금액


- 음료 추가
  - 이미 존재하는 음료이름인지 검증


- 현재 갖고있는 잔돈보다 음료 최소 가격이 큰지 확인
  - 작을 경우 투입금액 반환 (만약 정확히 반환할 수 없다면 가장 가까운 금액 반환)


### ✅ Changes
#### package java.vendingmachine.domain
- 현재 보유 중인 잔돈(HashMap)
- 전체 잔돈


- 잔돈 검증
  - 숫자인지
  - 10으로 나눠떨어지는지
  

- 무작위 동전 생성


- 반환할 잔돈 탐색


- 반환한 잔돈 제거


- 전체 잔돈 업데이트

### ✅ Beverage
#### package java.vendingmachine.domain
- 상품명
- 가격
- 수량

- 음료 객체 생성
  - 입력 형식 검증
  
  
- 수량 감소
  - 보유하고 있는 수량보다 많이 구매할 시 에러
  - 수량이 0이 되면 제품 삭제


- 음료 비용 최소값

### ✅ Beverages
#### package java.vendingmachine.domain
- Beverage를 관리하는 일급 컬렉션

- 음료 리스트 생성
  - 입력 형식 검증

- 음료 명으로 음료 조회

- 음료 가격의 최소값 조회

- 수량 감소
  - 보유하고 있는 수량보다 많이 구매할 시 에러
  - 수량이 0이 되면 제품 삭제


- 음료 비용 최소값


### ✅ Money
#### package java.vendingmachine.domain
- 금액


- 구매시 금액 감소

### ✅ Coin
#### package java.vendingmachine.domain.enums
- 코인 리스트 숫자로 가져오기
- 존재하는 코인인지 검증하기

### Service

------------

### ✅ VendingMachineProcessor
#### package java.vendingmachine.service

- 제품 구매
  ![image](https://user-images.githubusercontent.com/87312401/145228150-68aeb0bb-c50a-4b4d-878c-79a1d78f814b.png)

### ✅ VendingMachineChecker
#### package java.vendingmachine.service

- 종료, 재입력 상황 표시

### Controller

------------

### ✅ VendingMachineController
#### package java.vendingmachine.controller
- 기능 수행 담당
- 에러 핸들링 (입력값 에러시 반복 실행)


### View

------------

### ✅ InputView
#### package java.vendingmachine.view
- 자판기 보유 금액 입력
- 상품명, 가격, 수량 입력
- 투입 금액 입력
- 구매할 상품 입력


### ✅ OutputView
#### package java.vendingmachine.view
- 자판기가 보유한 동전 출력
- 남은 투입 금액 출력
- 잔돈 출력 (남지 않으면 남지 않았다고 출력)
- 개행 출력


### Validator

------------


### ✅ BeverageValidator
#### package java.vendingmachine.utils.validator

- 입력 형식 검증 (regex)
  - 처음과 마지막이 ```[```, ```]``` 인지
  - 가격이 100원 이상, 10원으로 나눠떨어지는 숫자인지
  - 수량이 1 이상의 숫자인지

### ✅ InputNumberValidator
#### package java.vendingmachine.utils.validator

- 숫자 입력값 검증
  - 숫자인지
  - 10으로 나눠 떨어지는지
