## 문제 설명

클래스 `SubrectangleQueries`를 구현하세요. 이 클래스는 생성자에서 `rows x cols` 크기의 정수 행렬을 받고, 두 가지 메서드를 지원합니다:

1. `updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)`
    - 좌상단 좌표가 `(row1, col1)`이고 우하단 좌표가 `(row2, col2)`인 부분 직사각형의 모든 값을 `newValue`로 업데이트합니다.
2. `getValue(int row, int col)`
    - 직사각형에서 좌표 `(row, col)`의 현재 값을 반환합니다.

## 예제

### 예제 1

- **입력**:
  ```plaintext
  ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
  [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
  ```
- **출력**:
  ```plaintext
  [null,1,null,5,5,null,10,5]
  ```
- **설명**:
  ```plaintext
  SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);
  // 초기 직사각형 (4x3)은 다음과 같습니다:
  // 1 2 1
  // 4 3 4
  // 3 2 1
  // 1 1 1
  subrectangleQueries.getValue(0, 2); // 반환값: 1
  subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
  // 업데이트 후 직사각형은 다음과 같습니다:
  // 5 5 5
  // 5 5 5
  // 5 5 5
  // 5 5 5
  subrectangleQueries.getValue(0, 2); // 반환값: 5
  subrectangleQueries.getValue(3, 1); // 반환값: 5
  subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
  // 업데이트 후 직사각형은 다음과 같습니다:
  // 5 5 5
  // 5 5 5
  // 5 5 5
  // 10 10 10
  subrectangleQueries.getValue(3, 1); // 반환값: 10
  subrectangleQueries.getValue(0, 2); // 반환값: 5
  ```

### 예제 2

- **입력**:
  ```plaintext
  ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"]
  [[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
  ```
- **출력**:
  ```plaintext
  [null,1,null,100,100,null,20]
  ```
- **설명**:
  ```plaintext
  SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
  subrectangleQueries.getValue(0, 0); // 반환값: 1
  subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
  subrectangleQueries.getValue(0, 0); // 반환값: 100
  subrectangleQueries.getValue(2, 2); // 반환값: 100
  subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
  subrectangleQueries.getValue(2, 2); // 반환값: 20
  ```

### 예제 3

- **입력**:
  ```plaintext
  ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
  [[[[2,8],[8,8],[7,4]]],[1,0],[1,1,1,1,4],[1,0],[0,0],[2,1,2,1,9],[1,1],[1,0]]
  ```
- **출력**:
  ```plaintext
  [null,8,null,8,2,null,4,8]
  ```
- **설명**:
  ```plaintext
  SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[2,8],[8,8],[7,4]]);
  subrectangleQueries.getValue(1, 0); // 8
  subrectangleQueries.updateSubrectangle(1,1,1,1,4);
  subrectangleQueries.getValue(1, 0); // 8
  subrectangleQueries.getValue(0, 0); // 2
  subrectangleQueries.updateSubrectangle(2,1,2,1,9);
  subrectangleQueries.getValue(1,1); // 4
  subrectangleQueries.getValue(1,0); // 8
  ```

## 제약 조건

- 두 메서드 `updateSubrectangle`와 `getValue`를 합쳐 최대 500번의 연산이 주어집니다.
- `1 <= rows, cols <= 100`
- `rows == rectangle.length`
- `cols == rectangle[i].length`
- `0 <= row1 <= row2 < rows`
- `0 <= col1 <= col2 < cols`
- $`1 <= newValue, rectangle[i][j] <= 10^9`$
- `0 <= row < rows`
- `0 <= col < cols`