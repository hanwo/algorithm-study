## 문제 설명

0-인덱스 정수 배열 `nums`와 목표 요소 `target`이 주어집니다. 
목표 인덱스는 `nums[i] == target`인 인덱스 `i`입니다.
`nums`를 비감소 순서로 정렬한 후 목표 인덱스의 리스트를 반환하세요. 
목표 인덱스가 없으면 빈 리스트를 반환하세요. 반환된 리스트는 오름차순으로 정렬되어야 합니다.

## 예제

### 예제 1
- **입력**: `nums = [1,2,5,2,3]`, `target = 2`
- **출력**: `[1,2]`
- **설명**: 정렬 후 `nums`는 `[1,2,2,3,5]`입니다. `nums[i] == 2`인 인덱스는 1과 2입니다.

### 예제 2
- **입력**: `nums = [1,2,5,2,3]`, `target = 3`
- **출력**: `[3]`
- **설명**: 정렬 후 `nums`는 `[1,2,2,3,5]`입니다. `nums[i] == 3`인 인덱스는 3입니다.

### 예제 3
- **입력**: `nums = [1,2,5,2,3]`, `target = 5`
- **출력**: `[4]`
- **설명**: 정렬 후 `nums`는 `[1,2,2,3,5]`입니다. `nums[i] == 5`인 인덱스는 4입니다.

## 제약 조건
- `1 <= nums.length <= 100`
- `1 <= nums[i], target <= 100`
