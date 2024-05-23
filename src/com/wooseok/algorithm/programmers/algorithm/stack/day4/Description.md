Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.

**Example 1:**

Input: s = "()"
Output: true

**Example 2:**

Input: s = "()[]{}"
Output: true

**Example 3:**

Input: s = "(]"
Output: false

**Constraints:**

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.


---

주어진 문자열 s는 오로지 문자 '(', ')', '{', '}', '[' 그리고 ']'만을 포함하고 있습니다. 이 입력 문자열이 유효한지 확인하세요.

입력 문자열이 유효한 조건:

- 열린 괄호는 같은 종류의 괄호로 닫혀야 합니다.
- 열린 괄호는 올바른 순서로 닫혀야 합니다.
- 모든 닫힌 괄호는 동일한 종류의 열린 괄호와 대응되어야 합니다.

**예시 1:**

입력: s = "()"
출력: true

**예시 2:**

입력: s = "()[]{}"
출력: true

**예시 3:**

입력: s = "(]"
출력: false

**제약 조건:**

1 <= s.length <= 104
s는 괄호 '()[]{}'만으로 구성됩니다.

