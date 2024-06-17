# 문제 설명

배열 `items`가 주어집니다. 각 $`items[i] = [type_i, color_i, name_i]`$는 $i^th$번째 아이템의 타입, 색상, 이름을 나타냅니다.  
또한 두 개의 문자열 `ruleKey`와 `ruleValue`로 표현된 규칙이 주어집니다.  
i번째 아이템이 다음 중 하나에 해당하면 규칙에 맞는다고 합니다:

- `ruleKey == "type"`이고 $`ruleValue == type_i`$.
- `ruleKey == "color"`이고 $`ruleValue == color_i`$.
- `ruleKey == "name"`이고 $`ruleValue == name_i`$.

주어진 규칙에 맞는 아이템의 개수를 반환하세요.

## 예제

### 예제 1

- 입력: `items = [["phone", "blue", "pixel"], ["computer", "silver", "lenovo"], ["phone", "gold", "iphone"]]`, `ruleKey = "color"`, `ruleValue = "silver"`
- 출력: `1`
- 설명: 주어진 규칙에 맞는 아이템은 오직 하나이며, 그것은 `["computer", "silver", "lenovo"]`입니다.

### 예제 2

- 입력: `items = [["phone", "blue", "pixel"], ["computer", "silver", "phone"], ["phone", "gold", "iphone"]]`, `ruleKey = "type"`, `ruleValue = "phone"`
- 출력: `2`
- 설명: 주어진 규칙에 맞는 아이템은 두 개이며, 그것들은 `["phone", "blue", "pixel"]`와 `["phone", "gold", "iphone"]`입니다. `["computer", "silver", "phone"]`는 규칙에 맞지 않습니다.

## 제약 사항

- $`1 <= items.length <= 10^4`$
- $`1 <= type_i.length, color_i.length, name_i.length, ruleValue.length <= 10`$
- `ruleKey`는 `"type"`, `"color"`, `"name"` 중 하나입니다.
- 모든 문자열은 소문자 영어 문자로만 구성됩니다.
