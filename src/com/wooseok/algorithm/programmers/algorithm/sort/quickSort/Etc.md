```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class quickSort {
	public static void main(Strings[] args) {
		int[] arr1 = {1, 8, 5, 9, 3, 7, 9, 1, 2};
		Arrays.sort(arr);

		List<Integer> intList = Arrays.asList(intArr);
		Collections.sort(intList);
		
		int[] arr2 = {1,2,3,4,5,6,7,8,9};
	}
}
```

## 만일 배열이 정렬 되어 있으면 최악의 시간 복잡도를 가진다.
하지만 이를 예방하기 위한 작업들이 존재한다.
1. 랜덤의 피벗 선택
2. 원소 3가지의 중간 값을 골라 피벗 설정
   1. 3가지의 중간 값을 가지는 방법
      1. $(a+b+c) / 3$
      2. $(a+b+c) - (최댓값) - (최솟값)$  
      ex) $`(arr[a] + arr[b] + arr[c]) - (Math.max(arr[a], Math.max(arr[b],arr[c]))) - (Math.min(arr[a], Math.min(arr[b],arr[c])))`$
