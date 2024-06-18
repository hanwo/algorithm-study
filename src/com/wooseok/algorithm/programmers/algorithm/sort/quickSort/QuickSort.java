package com.wooseok.algorithm.programmers.algorithm.sort.quickSort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] testArray1 = {3, 6, 8, 10, 1, 2, 1};
		int[] testArray2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] testArray3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] testArray4 = {5, 3, 8, 4, 2, 7, 1, 10};
		int[] testArray5 = {3, 6, 8, 10, 1, 2, 1, 15, 12, 14, 7, 9, 11, 13, 5, 4, 18, 17, 16, 19};
		int[] testArray6 = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] testArray7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
		int[] testArray8 = {5, 3, 8, 4, 2, 7, 1, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 6, 9};

		sort(testArray1);
		sort(testArray2);
		sort(testArray3);
		sort(testArray4);
		sort(testArray5);
		sort(testArray6);
		sort(testArray7);
		sort(testArray8);

		System.out.println("testArray1 = " + Arrays.toString(testArray1));
		System.out.println("testArray2 = " + Arrays.toString(testArray2));
		System.out.println("testArray3 = " + Arrays.toString(testArray3));
		System.out.println("testArray4 = " + Arrays.toString(testArray4));
		System.out.println("testArray5 = " + Arrays.toString(testArray5));
		System.out.println("testArray6 = " + Arrays.toString(testArray6));
		System.out.println("testArray7 = " + Arrays.toString(testArray7));
		System.out.println("testArray8 = " + Arrays.toString(testArray8));
	}

	public static void sort(int[] a) {
		pivotSort(a, 0, a.length - 1);
	}

	/*
	 * 중간 피벗 선택 방식
	 * @param a : 정렬할 배열
	 * @param left : 현재 부분배열의 왼쪽
	 * @param right : 현재 부분배열의 오른쪽
	 * */
	private static void pivotSort(int[] a, int left, int right) {
		/*
		 * low가 high보다 크거나 같다면
		 * 정렬 할 원소가 1개 이하이므로
		 * 정렬하지 않고 리턴
		 * */
		if (left >= right)
			return;

		/*
		 * 피벗을 기준으로 요소들이 왼쪽과 오른쪽으로 약하게 정렬 된 상태로
		 * 만들어 준 뒤, 최종적으로 pivot의 위치를 얻는다.
		 *
		 * 그리고나서 해당 피벗을 기준으로
		 * 왼쪽 부분리스트와 오른쪽 부분리스트로 나누어 분할 정복
		 *
		 * [과정]
		 *
		 * Partitioning:
		 *
		 *      left part      a[(right + left)/2]      right part
		 * +---------------------------------------------------------+
		 * |    element < pivot    |  pivot  |    element >= pivot   |
		 * +---------------------------------------------------------+
		 *
		 * result After Partitioning:
		 *
		 *         left part         a[right]          right part
		 * +---------------------------------------------------------+
		 * |   element < pivot    |  pivot  |    element >= pivot    |
		 * +---------------------------------------------------------+
		 *
		 * result : pivot = right
		 *
		 * Recursion:
		 *
		 *  m_pivot_sort(a, left, pivot)         m_pivot_sort(a, pivot + 1, right)
		 *
		 *         left part                           right part
		 * +-----------------------+             +-----------------------+
		 * |   element <= pivot    |             |    element > pivot    |
		 * +-----------------------+             +-----------------------+
		 * left                pivot          pivot + 1                   right
		 *
		 *
		 * */
		int pivot = partition(a, left, right);

		pivotSort(a, left, pivot);
		pivotSort(a, pivot + 1, right);
	}

	/*
	 * pivot을 기준으로 파티션을 나누기 위한 정렬 메소드
	 * 피벗보다 작은 값들은 왼쪽에, 큰 값들은 오른쪽에 치중하도록 하는 것
	 *
	 * @param a : 정렬 할 배열
	 * @param left : 현재 배열의 가장 왼쪽 부분
	 * @param right : 현재 배열의 가장 오른쪽 부분
	 * @return : 최종적으로 위치한 피벗의 위치(right)를 반환
	 * */
	private static int partition(int[] a, int left, int right) {
		int low = left - 1;
		int high = right + 1;
		int pivot = a[(left + right) / 2]; //부분리스트의 중간 요소를 피벗으로 설정

		while (true) {
			/*
			 * 1 증가시키고 난 뒤의 low 위치의 요소가
			 * pivot보다 크거나 같은 요소를 찾을 때까지 반복
			 * */
			do {
				low++;
			} while (a[low] < pivot);

			/*
			 * 1 감소시키고 난 뒤의 high 위치가 lo보다 크거나 같은 위치이면서
			 * high 위치의 요소가 pivot보다 작거나 같은 요소를 찾을 때까지 반복
			 * */
			do {
				high--;
			} while (a[high] > pivot && low <= high);

			/*
			 * 만약 hi가 lo보다 크지 않다면(엇갈린다면) swap하지 않고 high 리턴
			 * */
			if (low >= high)
				return high;

			swap(a, low, high);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}

/**
 * 질문
 * 내림 차순으로 변경하려면?
 */

/**
 * 딱 2 곳을 변경하면 되지롱
 */
