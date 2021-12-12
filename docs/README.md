# 프리코스 3주차 미션 - 자판기

## 구현할 기능 목록

    -사용자가 입력한 자판기 보유 금액이 10의 배수인 0이상의 정수인지 검증
    
    -자판기가 보유한 금액에 맞도록 동전을 무작위로 생성
    
    -사용자가 입력한 문자열이 [상품명, 가격, 수량] 의 형식에 맞는지 검증
    
    -사용자가 입력한 문자열을 대괄호와 쉼표를 기준으로 분리
    
    -상품의 가격이 10의 배수인 100이상의 정수인지 검증
    
    -상품의 수량이 0 이상의 정수인지 검증
    
    -사용자가 입력한 투입금액이 0이상의 정수인지 검증
    
    -사용자가 입력한 구매 상품명이 상품 목록에 있는지 검증
    
    -잔돈을 반환해야 하는 상황인지 확인
    
    -최소 개수의 동전으로 잔돈을 반환하는 방법을 확인
    
    -사용자의 입력 전후에 공백이 있으면 제거


## 예외 처리 사항

    -자판기가 보유한 금액의 입력값이 0이상의 정수가 아니거나 10으로 나누어 떨어지지 않는 경우
    
    -입력된 문자열이 [상품명, 가격, 수량] 의 형식에 맞지 않는 경우
    
    -입력된 상품의 가격 또는 수량이 정수가 아닌 경우
    
    -상품의 가격이 100원 미만이거나 10으로 나누어 떨어지지 않는 경우
    
    -입력된 상품의 수량이 음수인 경우
    
    -투입금액이 숫자가 0 이상의 정수가 아닌 경우
    
    -구매할 상품명이 목록에 없는 경우


## 클래스 목록

### main.java.vendingmachine

    -Application: main 메소드가 위치하는 클래스


#### Model 패키지
    
    -Coin: 동전의 이름과 액수정보를 담고 있는 enum 클래스
    
    -CoinPair: Coin 객체와 해당 동전의 개수를 담고 있는 모델
    
    -Coins: List<CoinPair> 형태로 보유한 동전들의 정보를 담고 있는 모델
    
    -Drink: 음료의 정보를 담고있는 모델 
    
    -User: 사용자의 정보를 담고있는 모델
    
    -VendingMachine: 자판기의 정보를 담고있는 모델


#### Controller 패키지

    -VendingController: 자판기를 가동하는 컨트롤러 클래스. 모델과 뷰를 연결한다. 

#### View 패키지

    -InputView: 입력을 담당하는 뷰 클래스
    
    -OutputView: 출력을 담당하는 뷰 클래스


#### Service 패키지

    -MachineSetting: 사용자의 입력을 받아 vendingMachine 객체를 초기화 
    
    -UserSetting: 사용자의 입력을 받아 User 객체를 초기화
    
    -Transaction: 사용자의 선택을 입력으로 받아 거래를 진행
    
    -ReturnChange: 잔돈을 계산하여 반환


#### Validator 패키지

    -DrinkListValidator: 음료 정보에 관련된 사용자의 입력이 유효한지 검증
    
    -MoneyValidator: 금액에 관련된 사용자의 입력이 유효한지 검증
    
    -NumberValidator: 숫자에 관련된 사용자의 입력이 유효한지 검증
    
    -TransactionValidator: 거래과정에서 사용자의 음료 선택이 유효한지 검증


#### SystemMessage 패키지

    -ErrorMessage: 에러문구를 모아 놓은 클래스 
    
    -NoticeMessage: 안내문구를 모아 놓은 클래스


#### Constant 패키지

    -Constant: 상수를 모아 놓은 클래스


### test.java.vendingmachine

    -ApplicationTest: 기능 테스트를 위한 클래스


