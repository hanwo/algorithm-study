package com.wooseok.algorithm.programmers.algorithm.heap.day39;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class The_K_Weakest_Rows_in_a_Matrix {

	public static void main(String[] args) {

		int[][] mat1 = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
		int[][] mat2 = {{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};

		int k1 = 3;
		int k2 = 2;

		System.out.println("kWeakestRows(mat1, k1) = " + Arrays.toString(kWeakestRows(mat1, k1)));
		System.out.println("kWeakestRows(mat2, k2) = " + Arrays.toString(kWeakestRows(mat2, k2)));

	}

	public static int[] kWeakestRows(int[][] mat, int k) {
		Map<Integer, Integer> soliderMap = new HashMap<>();
		for (int i = 0; i < mat.length; i++) {
			int[] soldiers = mat[i];
			int soldierCount = 0;
			for (int soldier : soldiers) {
				if (soldier == 1) {
					soldierCount++;
				}
			}
			soliderMap.put(i, soldierCount);
		}

		return Arrays.copyOf(soliderMap.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByValue())
			.collect(Collectors.toMap(
				Map.Entry::getKey,
				Map.Entry::getValue,
				(e1, e2) -> e1,
				LinkedHashMap::new
			)).keySet()
			.stream()
			.mapToInt(Integer::intValue
			).toArray(), k);
	}
}
