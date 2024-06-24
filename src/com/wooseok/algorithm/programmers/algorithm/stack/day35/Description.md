`RecentCounter` 클래스는 특정 시간 프레임 내에서 최근 요청의 수를 세는 역할을 합니다.

### RecentCounter 클래스 구현

- `RecentCounter()`: 최근 요청이 0인 상태로 카운터를 초기화합니다.
- `int ping(int t)`: 시간 `t`에 새로운 요청을 추가하고, 지난 3000밀리초 동안 발생한 요청의 수를 반환합니다(새로운 요청 포함). 구체적으로, `[t - 3000, t]` 범위 내에서 발생한 요청의 수를 반환합니다. 모든 `ping` 호출은 이전 호출보다 엄격히 큰 `t` 값을 사용합니다.

## 예제

### 예제 1

- **입력**: `["RecentCounter", "ping", "ping", "ping", "ping"]`, `[[], [1], [100], [3001], [3002]]`
- **출력**: `[null, 1, 2, 3, 3]`
- **설명**:
  1. `RecentCounter recentCounter = new RecentCounter();`
  2. `recentCounter.ping(1);` 
     - 요청: `[1]`
     - 범위: `[-2999, 1]`
     - 반환: `1`
  3. `recentCounter.ping(100);`
     - 요청: `[1, 100]`
     - 범위: `[-2900, 100]`
     - 반환: `2`
  4. `recentCounter.ping(3001);`
     - 요청: `[1, 100, 3001]`
     - 범위: `[1, 3001]`
     - 반환: `3`
  5. `recentCounter.ping(3002);`
     - 요청: `[1, 100, 3001, 3002]`
     - 범위: `[2, 3002]`
     - 반환: `3`

## 제약 조건

- $`1 <= t <= 10^9`$
- 각 테스트 케이스는 엄격히 증가하는 `t` 값을 사용하여 `ping`을 호출합니다.
- $`ping` 호출은 최대 `10^4`번 이루어집니다.$