길이가 n인 정수 배열 nums(0부터 인덱스화)과 정수 target이 주어졌을 때, `0 <= i < j < n`이고 `nums[i] + nums[j] < target`을 만족하는 `(i, j)` 쌍의 수를 반환합니다.

**예시 1:**

입력: nums = [-1,1,2,3,1],  
target = 2  
출력: 3  
설명: 문제에서 조건을 만족하는 인덱스 쌍은 다음과 같이 3개가 있습니다:
- (0, 1)은 0 < 1이고 nums[0] + nums[1] = 0 < target
- (0, 2)은 0 < 2이고 nums[0] + nums[2] = 1 < target
- (0, 4)은 0 < 4이고 nums[0] + nums[4] = 0 < target  
  (0, 3)은 nums[0] + nums[3]이 target보다 엄격하게 작지 않기 때문에 세지 않습니다.

**예시 2:**

입력: nums = [-6,2,5,-2,-7,-1,3],  
target = -2  
출력: 10  
설명: 문제에서 조건을 만족하는 인덱스 쌍은 다음과 같이 10개가 있습니다:
- (0, 1)은 0 < 1이고 nums[0] + nums[1] = -4 < target
- (0, 3)은 0 < 3이고 nums[0] + nums[3] = -8 < target
- (0, 4)은 0 < 4이고 nums[0] + nums[4] = -13 < target
- (0, 5)은 0 < 5이고 nums[0] + nums[5] = -7 < target
- (0, 6)은 0 < 6이고 nums[0] + nums[6] = -3 < target
- (1, 4)은 1 < 4이고 nums[1] + nums[4] = -5 < target
- (3, 4)은 3 < 4이고 nums[3] + nums[4] = -9 < target
- (3, 5)은 3 < 5이고 nums[3] + nums[5] = -3 < target
- (4, 5)은 4 < 5이고 nums[4] + nums[5] = -8 < target
- (4, 6)은 4 < 6이고 nums[4] + nums[6] = -4 < target

**제한 사항:**

`1 <= nums.length == n <= 50`  
`-50 <= nums[i], target <= 50`
