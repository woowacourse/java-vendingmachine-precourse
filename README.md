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

## 3주차 과제 수행시 키포인트

- 객체의 각 필드에도 wrapping class를 적용함
    - 원시변수 및 if문의 최소화 -> 래핑변수 및 stream의 활용
- 정규식 패턴검사에 stream을 활용함
- List대신 Map 자료구조 래핑하여 DB처럼 사용함
    - 상품 정보등은 List를 포장한 일급컬렉션으로 만들어놓고 정보조회시 사용함
- 싱글톤 객체를 활용하여 전체 로직을 운영함
    - controller 반복문의 조건변수도 싱글톤객체에 메세지를 보내니 상태에 따른 값을 얻어와서 구현하기 수월했음
- 자판기 작동 로직에 대해 고민하여 기능 구현 목록을 작성함

## 요구사항 체크리스트

### 1주차

- [x] 자바의 버전이 8버전인가
- [x] 자바 코드 컨벤션을 지키는가
- [ ] `Randoms`의 `pickNumberInRange()`를 사용했는가
    - [x] (3주차) `pickNumberInList()`를 사용했는가
- [x] `Console`의 `readLine()`을 사용했는가
- [x] 3항 연산자를 쓰지 않는가
- [x] **indent depth가 2이하인가**
- [x] **하나의 함수가 한 가지 일만 하도록 하였는가**
- [x] **(추가) 하드코딩 하진 않았는가**
- [x] **(추가) style check 및 convention 적용 하였는가**
- [x] **`gradlew.bat clean test`의 모든 테스트가 통과하는가**
- [x] **과제 제출시 우테코 플랫폼에서도 제출하였는가**

### 2주차(피드백 및 과제에서 추가)

- [x] **함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.**
- [x] else 예약어를 쓰지 않는다

- [x] **기능 목록을 업데이트하고 재검토 한다**
- [x] **Class 구현순서( 상수->멤버 변수->생성자->메서드) 지키기**

### 3주차

- [x] **기능 목록에 예외상황도 기록한다.**
- [x] **일급컬랙션 및 단일변수도 포장한다.**
- [x] 변수를 줄이려고 노력한다.

## 추가 학습사항

- **[java 기본 문법 정리하기](https://github.com/is2js/exampleStudy01)**
    - [x] 1코테~1주차 과제기간 자바의 정석 등 기본문법
    - [x] 2주차 과제기간 Enum(day10), Interface(day11) 추가 학습
    - [x] **3주차 과제기간 파일입출력(day12) 추가 학습** : [설명](https://github.com/is2js/exampleStudy01/blob/master/readme.md)
      ,  [코드](https://github.com/is2js/exampleStudy01/tree/master/src/main/java)


- **[백준 python 기본 구현 문제](https://github.com/is2js/python_algorithm) -> java 로 풀어보면서 개념정리하기**
    - [x] 1~2주차 [문제풀이](https://github.com/is2js/boj_java)
      및 [개념정리](https://github.com/is2js/boj_java/blob/master/concept.md)
    - [x] 2주차 과제기간 [stream 코드를 통한 개념 정리](https://github.com/is2js/boj_java/blob/master/concept.md)
    - [x] **3주차 과제기간 stream위주로 [로또게임](https://github.com/is2js/MVC_practice/tree/master/src/main/java/lotto2ByMe)
      구현해보기**


- **java로 콘솔 게시판 만들어보기 [설명](https://github.com/is2js/exampleStudy01/blob/master/board.md)
  , [코드](https://github.com/is2js/exampleStudy01/tree/master/src/main/java/board)**
    - [x] 1주차 콘솔 게시판까지 완성
    - [x] 2주차 콘솔 게시판 정렬+페이징 기능 구현
    - [x] **3주차 콘솔 게시판 입출력기능(저장 및 불러오기) 구현**


- **지난 과제**를 지원동기들 코드 참고하여 **다시 작성해보기**
    - [x] [1주차과제 복습](https://github.com/is2js/MVC_practice/tree/master/src/main/java/baseball2Youngyooon) : 숫자야구게임 **
      MVC+ 일급콜렉션 적용** 위주로 코드 새로 짜기
    - [x] [2주차과제 복습](https://github.com/is2js/MVC_practice/tree/master/src/main/java/racingCar3devhudiForWrap) : **최소단위
      변수들도 Wrapping클래스** 만들어보기 & 인터페이스 적용해보기
