# 미션 - 자판기

## 구현할 기능 목록

### 👛 자판기 동전 초기 설정

- 자판기가 보유하고 있는 금액을 입력받는다.
    * 입력 형식은 다음과 같다.
        * 자판기가 보유하고 있는 금액을 입력해 주세요.
        * [$금액]
    * 허용되지 않은 입력의 경우 IllegalArgumentException 이 발생하고, 에러 메시지를 출력한 뒤 다시 입력 받는다.
    * 0 이상이며 10으로 나누어떨어지는 정수만 허용한다.
        * 에러 메시지 출력 형식은 다음과 같다.
        * [ERROR] 자판기가 보유하고 있는 금액은 0 이상이며 10으로 나누어떨어지는 정수여야 합니다.
- 자판기가 보유한 금액을 이용하여 무작위로 동전을 생성한다.
    * 동전의 종류는 500원, 100원, 50원, 10원이다.
    * 동전의 개수는 0 이상의 정수만 허용한다.
- 생성된 동전을 출력한다.
    * 동전의 개수가 0개일 경우에도 출력한다.
    * 출력 형식은 다음과 같다.
        * 자판기가 보유한 동전
        * [$동전금액]원 - [$동전개수]개

### 🎁 자판기 상품 추가

- 상품명, 가격, 수량을 입력받아 자판기의 상품을 추가한다.
    * 입력 형식은 다음과 같다.
        * 상품명과 가격, 수량을 입력해 주세요.
        * [[$상품명],[$가격],[$수량]];[[$상품명],[$가격],[$수량]]
    * 허용되지 않은 입력의 경우 IllegalArgumentException 이 발생하고, 에러 메시지를 출력한 뒤 다시 입력 받는다.
    * 지정된 입력 형식과 다른 형식으로 입력하는 경우는 허용하지 않는다.
        * 에러메시지 출력 형식은 다음과 같다.
        * [ERROR] 입력형식에 맞춰 입력해주세요.
    * 상품은 1개 이상이어야 한다.
        * 에러메시지 출력 형식은 다음과 같다.
        * [ERROR] 1개 이상의 상품을 입력해 주세요.
    * 상품의 이름이 중복되는 경우는 허용하지 않는다.
        * 에러메시지 출력 형식은 다음과 같다.
        * [ERROR] 중복된 이름의 상품은 등록이 불가능합니다.
    * 각 상품의 수량은 0 이상의 정수만 허용한다.
        * 에러메시지 출력 형식은 다음과 같다.
        * [ERROR] 상품의 수량은 0 이상의 정수여야 합니다.
    * 각 상품의 가격은 10원 이상이며 10으로 나누어떨어지는 정수만 허용한다.
        * 에러 메시지 출력 형식은 다음과 같다.
        * [ERROR] 상품의 가격은 10원 이상이며 10으로 나누어떨어지는 정수여야 합니다.

### 💰 투입 금액 입력

- 자판기 상품 구매를 위해 투입할 금액을 입력한다.
    * 입력 형식은 다음과 같다.
        * 투입 금액을 입력해주세요
        * [$투입금액]
    * 허용되지 않은 입력의 경우 IllegalArgumentException 이 발생하고, 에러 메시지를 출력한 뒤 다시 입력 받는다.
    * 0 이상의 정수만 허용한다.
        * 에러 메시지 출력 형식은 다음과 같다.
        * [ERROR] 투입 금액은 0 이상의 정수여야 합니다.

### 🛒 상품 구매

- 현재 남은 투입 금액을 출력한다.
    * 출력 형식은 다음과 같다.
        * 투입 금액: [$투입금액]원
- 상품 구매가 가능한 경우 상품명을 입력받아 상품 구매를 진행한다.
    * 입력 형식은 다음과 같다.
        * 구매할 상품명을 입력해 주세요.
        * [$상품명]
    * 허용되지 않은 입력의 경우 IllegalArgumentException 이 발생하고, 에러 메시지를 출력한 뒤 다시 입력 받는다.
    * 추가되어 있지 않은 상품은 구매가 불가능하다.
        * 에러 메시지 출력 형식은 다음과 같다.
        * [ERROR] 자판기에 존재하지 않는 상품입니다. 다른 상품을 선택해주세요.
    * 남은 수량이 1 이상인 상품만 허용된다.
        * 에러 메시지 출력 형식은 다음과 같다.
        * [ERROR] 남은 수량이 없는 상품입니다. 다른 상품을 선택해주세요.
    * 현재 남은 투입 금액보다 적은 가격의 상품만 허용된다.
        * 에러 메시지 출력 형식은 다음과 같다.
        * [ERROR] 투입 금액으로 구매할 수 없는 상품입니다. 다른 상품을 선택해주세요.
    * 상품 구매가 불가능한 상황이 될 때까지 반복한다.
- 상품 구매가 불가능한 경우 상품 구매가 종료된다.
    * 상품 구매가 불가능한 경우는 다음과 같다.
        * 남은 투입 금액이 구매 가능한 상품들 중 최소 금액 상품보다 적은 경우
        * 모든 상품이 소진된 경우

### 💸 잔돈 출력

- 최소한의 동전 개수를 이용하여 잔돈을 구성한다.
    * 잔돈을 반환할 수 없는 경우 반환할 수 있는 금액만 구성한다.
- 잔돈을 출력한다.
    * 동전의 개수가 0개일 경우에는 아무것도 출력하지 않는다.
    * 출력 형식은 다음과 같다.
        * 잔돈
        * [$동전금액]원 - [$동전개수]개

---

## 클래스 명세

### MainController

- start() : 자판기 시작

### InitController

- initVendingMachine() : 자판기 보유금액, 상품, 투입금액 초기화 함수 호출
- initHoldingCoins() : 자판기 보유금액 초기화
- initProducts() : 상품정보 초기화
- initInputAmount() : 투입금액 초기화

### PurchaseController

- startPurchasing() : 상품구매가 불가능해질 때까지 상품 구매 반복
- purchase() : 상품 구매

### ChangeController

- returnChange() : 잔돈 돌려주기

### InitHoldingCoinsService

- setHoldingCoins() : 자판기 보유 동전 설정
- addPickedCoin : 선택된 동전 자판기 보유동전에 추가
- pickRandomCoin : 랜덤으로 동전 선택

### InitProductListService

- setProducts() : 자판기 상품 설정
- parseProductInfo() : 입력된 자판기 상품 정보 파싱

### InitInputAmountService

- setInputAmount() : 투입금액 설정

### PurchaseService

- purchase() : 상품 구매 진행
- isAvailable() : 구매 가능한 상황인지 확인

### ChangeService

- calculateChange() : 잔돈 계산

### CommonValidation : 공통 검증부분

- isExist() : null 혹은 빈값을 입력했는지 확인
- isInteger() : 정수인지 확인
- isMoreThanNum() : 해당값보다 더 큰지 확인
- isDividedByNum() : 해당값으로 나누어 떨어지는지 확인

### HoldingAmountValidation : 자판기 보유금액 검증

- isValidHoldingAmount() : 잘못된 입력으로 확인된 경우 예외발생
- checkBasic() : 존재하는지, 정수인지 확인
- checkCondition() : 자판기 보유금액의 최솟값보다 큰지, 10으로 나누어 떨어지는지 확인

### InputAmountValidation : 투입금액 검증

- isValidInputAmount() : 잘못된 입력으로 확인된 경우 예외발생
- checkBasic() : 존재하는지, 정수인지 확인
- checkCondition() : 투입금액의 최솟값보다 큰지 확인

### ProductValidation : 상품정보 검증

- isValidProductFormat() : 잘못된 입력으로 확인된 경우 예외발생
- checkArrayFormat() : 올바른 입력 형식인지 확인
- checkVariables() : 모든 입력값이 존재하는지 확인
- isValidProductInfo() : 이름,가격,수량 확인
- checkName() : 자판기에 이미 존재하는 상품의 이름과 중복되는지 확인
- checkCost() : 10 이상이며 10으로 나누어떨어지는 정수인지 확인
- checkCount() : 0이상의 정수인지 확인

### ProductToPurchaseValidation : 구매하려는 상품 검증

- isValid() : 잘못된 입력으로 확인된 경우 예외발생
- isExistProduct() : 자판기에 존재하는 상품인지 확인
- isRemainingProduct() : 남은 수량이 1이상인지 확인
- canPurchaseWithThat() : 현재 남아있는 투입 금액으로 구매할 수 있는지 확인

### InputAmount

- int inputAmount : 투입금액
- inputMoney() : 금액 투입
- takeMoney() : 상품 구매하여 투입금액 감소
- isMoreThanNum() : 해당금액보다 더 큰지 확인
- calculateMaxNumber() : 투입금액을 해당동전으로 돌려주기위해 필요한 최대 개수 계산
- printInputAmount() : 투입금액 출력을 위한 양식으로 변환

### Product

- String name : 이름
- int cost : 가격
- int count : 수량
- Product() : 생성자
- isSameName() : 해당이름과 같은 이름인지 확인
- isRemain() : 수량이 1이상인지 확인
- canPurchase() : 현재 남은 투입금액으로 구매 가능한 상품인지 확인
- purchase()  : 구매

### Coin

- getAmountList() : 동전값들 모두 반환
- getCoinByAmount() : 동전값을 통해 해당 동전 반환
- getAmount() : 동전 값 반환
- calculateTotalAmount() : 해당 동전과 해당 개수를 이용하여 줄 수 있는 최대 금액
- printAmount() : 동전값 출력을 위한 양식으로 변환

### Coins

- Map<Coin, Integer> holdingCoins : 자판기가 보유하고 있는 동전
- Map<Coin, Integer> change : 잔돈
- addToHoldingCoins() : 자판기가 보유하고 있는 동전에 동전 추가
- addToChange() : 잔돈에 동전 추가
- calculateNumberOfCoin() : 잔돈으로 돌려주기 위해 필요한 동전개수 계산
- printHoldingCoins() : 자판기가 보유하고 있는 동전 출력을 위한 양식으로 변환
- printChange() : 잔돈 출력을 위한 양식으로 변환
- printCoins() : 전체 동전 출력을 위한 양식으로 변환
- printCoin() : 동전 하나하나의 출력을 위한 양식으로 변환

### VendingMachine

- List<Product> products : 자판기에 존재하는 상품들의 정보
- addProduct() : 자판기에 상품 추가
- clearList() : 자판기 상품 모두 삭제
- findProductByName() : 이름을 이용하여 상품 찾기
- isAnyThingToPurchase() : 구매 가능한 상품이 존재하는지 확인
- findAndPurchase() : 상품이름을 이용하여 상품 구매

### DomainConstant

- Domain과 관련된 상수

### ErrorConstant

- 에러출력을 위한 상수

### InputConstant

- 입력값을 받기 위한 상수

### OutputConstant

- 출력을 위한 상수