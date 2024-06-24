package com.wooseok.algorithm.programmers.algorithm.stack.day36;

import java.util.Arrays;

public class Final_Prices_With_a_Special_Discount_in_a_Shop {

	public static void main(String[] args) {
		int[] prices1 = {8, 4, 6, 2, 3};
		int[] prices2 = {1, 2, 3, 4, 5};
		int[] prices3 = {10, 1, 1, 6};
		int[] prices4 = {8, 7, 4, 2, 8, 1, 7, 7, 10, 1};

		System.out.println("finalPrices(prices1) = " + Arrays.toString(finalPrices(prices1)));
		System.out.println("finalPrices(prices2) = " + Arrays.toString(finalPrices(prices2)));
		System.out.println("finalPrices(prices3) = " + Arrays.toString(finalPrices(prices3)));
		System.out.println("finalPrices(prices4) = " + Arrays.toString(finalPrices(prices4)));
	}

	public static int[] finalPrices(int[] prices) {
		int[] answer = new int[prices.length];

		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] >= prices[j]) {
					answer[i] = prices[i] - prices[j];
					break;
				} else {
					answer[i] = prices[i];
					answer[j] = prices[j];
				}
			}
		}

		answer[prices.length - 1] = prices[prices.length - 1];

		return answer;
	}
}
