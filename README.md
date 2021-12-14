# 미션 - 자판기

## 🔍 진행방식

- 미션은 **기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항** 세 가지로 구성되어 있다.
- 세 개의 요구사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## ✉️ 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
   - GitHub을 활용한 제출 방법은 [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 를 참고해 제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원 플랫폼](https://apply.techcourse.co.kr) 에 접속하여 프리코스 과제를 제출한다.
   - 자세한 방법은 [링크](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 를 참고한다.
   - **Pull Request만 보내고, 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## ✔️ 과제 제출 전 체크리스트 - 0점 방지

- 터미널에서 `java -version`을 실행해 자바 8인지 확인한다. 또는 Eclipse, IntelliJ IDEA와 같은 IDE의 자바 8로 실행하는지 확인한다.
- 터미널에서 맥 또는 리눅스 사용자의 경우 `./gradlew clean test`, 윈도우 사용자의 경우 `gradlew.bat clean test` 명령을 실행했을 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구사항

반환되는 동전이 최소한이 되는 자판기를 구현한다.

- 자판기가 보유하고 있는 금액으로 동전을 무작위로 생성한다.
   - 투입 금액으로는 동전을 생성하지 않는다.
- 잔돈을 돌려줄 때 현재 보유한 최소 개수의 동전으로 잔돈을 돌려준다.
- 지폐를 잔돈으로 반환하는 경우는 없다고 가정한다.
- 상품명, 가격, 수량을 입력하여 상품을 추가할 수 있다.
   - 상품 가격은 100원부터 시작하며, 10원으로 나누어떨어져야 한다.
- 사용자가 투입한 금액으로 상품을 구매할 수 있다.
- 남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다.
- 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다.
   - 반환되지 않은 금액은 자판기에 남는다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 해당 부분부터 다시 입력을 받는다.
- 아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.

### ✍🏻 입출력 요구사항

#### ⌨️ 입력

- 상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분한다.

```
[콜라,1500,20];[사이다,1000,10]
```

#### 🖥 출력

- 자판기가 보유한 동전

```
500원 - 0개
100원 - 4개
50원 - 1개
10원 - 0개
```

- 잔돈은 반환된 동전만 출력한다.

```
100원 - 4개
50원 - 1개
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR]로 시작해야 한다.

```
[ERROR] 금액은 숫자여야 합니다.
```

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

## 🎱 프로그래밍 요구사항

- 프로그램을 실행하는 시작점은 `Application`의 `main()`이다.
- JDK 8 버전에서 실행 가능해야 한다. **JDK 8에서 정상 동작하지 않을 경우 0점 처리**한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
   - https://naver.github.io/hackday-conventions-java
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
   - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
   - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
   - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
   - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
   - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 프로그래밍 요구사항에서 별도로 변경 불가 안내가 없는 경우 파일 수정과 패키지 이동을 자유롭게 할 수 있다.

### 프로그래밍 요구사항 - Coin

- Coin 클래스를 활용해 구현해야 한다.
- 필드(인스턴스 변수)인 `amount`의 접근 제어자 private을 변경할 수 없다.

```java
public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
}
```

### 프로그래밍 요구사항 - Randoms, Console

- JDK에서 기본 제공하는 Random, Scanner API 대신 `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console` API를 활용해 구현해야 한다.
   - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInList()`를 활용한다.
   - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 디렉터리의 `ApplicationTest`에 있는 모든 테스트 케이스가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**

---

## 📈 과제 진행 요구사항

- 미션은 [java-vendingmachine-precourse](https://github.com/woowacourse/java-vendingmachine-precourse) 저장소를 Fork/Clone해 시작한다.
- **기능을 구현하기 전에 java-vendingmachine-precourse/docs/README.md 파일에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위**로 추가한다.
   - [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해 commit log를 남긴다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 를 참고한다.

- 💻 구현할 목록
    - 난수를 생성하는 클래스 구현(branch: feature/random-number)
    - 난수를 통해 각 코인 종류 별로 알맞는 코인 갯수를 만드는 클래스 구현(branch: feature/coin-type-amount-generator)
    - 각 제품의 정보를 저장하는 클래스 구현(branch: feature/products)
    - 자판기를 가동하기 위해 필요한 데이터를 관리하는 클래스 구현(branch: feature/vending-machine)
    - 자판기 view에서 필요한 메시지를 담당하는 클래스 구현(branch: feature/vending-machine-message)
        1. 자판기에 입력할 데이터를 안내하는 메시지
        2. 자판기에서 처리된 결과를 출력하는 메시지
        3. 유효하지 않은 데이터 입력에 대한 예외처리(5~6번 구현: branch: /feature/validate-inputted-data)
            1. 숫자 데이터 길이가 너무 짧은 경우
            2. 유효하지 않은 숫자가 들어온 경우
            3. 숫자가 아닌 다른 것을 입력한 경우
            4. 공백이 들어오면 안되는 곳에 공백이 들어온 경우
            5. 상품정보입력에서 '['와 ']'의 쌍이 맞지 않는 경우
            6. 상품정보 입력에서 두 제품 사이가 ';'로 구분되 있지 않은 경우
            7. 하나의 상품정보에 이름, 가격, 수량 중 하나 이상이 없는 경우
    - 자판기에 필요한 데이터를 입력받는 클래스 구현(branch: feature/input-data)
        1. 자판기가 보유하고 있는 금액을 입력받는다.
        2. 상품명과 가격, 수량을 입력받는다.
        3. 제품 구매를 위해 투입할 금액을 입력받는다.
        4. 구매할 상품을 입력한다.
    - 입력한 데이터의 유효여부를 검증하는 클래스 구현(branch: feature/validate-inputted-data)
        1. 숫자 데이터에 대한 검증
            1. 1의 자리가 0인 2자리 이상의 정수는 유효한 수이다
            2. 숫자는 공백을 포함하지 않는다
            3. 숫자는 음수 또는 소수이지 않는다
        1. 제품 정보에 대한 검증
            1. 괄호 쌍이 맞지 않는 경우
            2. 두 제품이 ;으로 분리되 있지 않은 경우
            3. 하나의 제품에 대한 정보인 이름, 가격, 수량이 ,로 분리되 있지 않은 경우
    - 자판기 내부 로직 수행 후 결과를 알려주는 클래스 구현(branch: feature/output-result)
        1. 자판기가 보유한 동전 리스트를 출력한다.
        2. 유저가 투입한 금액을 출력한다.
        3. 잔돈 내역을 출력한다.
    - 자판기 내부에 있는 동전 종류를 가져오는 기능 구현 (branch: feature/vending-machine-controller)
