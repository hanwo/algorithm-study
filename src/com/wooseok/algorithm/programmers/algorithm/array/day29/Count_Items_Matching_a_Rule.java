package com.wooseok.algorithm.programmers.algorithm.array.day29;

import java.util.List;

public class Count_Items_Matching_a_Rule {

	public static void main(String[] args) {
		List<List<String>> items = List.of(
			List.of("phone", "blue", "pixel"),
			List.of("computer", "silver", "lenovo"),
			List.of("phone", "gold", "iphone")
		);
		String ruleKey1 = "color";
		String ruleValue1 = "silver";

		String ruleKey2 = "type";
		String ruleValue2 = "phone";

		List<List<String>> items2 = List.of(
			List.of("qqqq", "qqqq","qqqq"),
			List.of("qqqq", "qqqq","qqqq"),
			List.of("qqqq", "qqqq","qqqq"),
			List.of("qqqq", "qqqq","qqqq"),
			List.of("qqqq", "qqqq","qqqq"),
			List.of("qqqq", "qqqq","qqqq"),
			List.of("qqqq", "qqqq","qqqq")
		);

		String ruleKey3 = "name";
		String ruleValue3 = "qqqq";

		// 1
		System.out.println("countMatches(items, ruleKey1, ruleValue1) = " + countMatches(items, ruleKey1, ruleValue1));
		// 2
		System.out.println("countMatches(items, ruleKey2, ruleValue2) = " + countMatches(items, ruleKey2, ruleValue2));
		// 7
		System.out.println("countMatches(items2,ruleKey3,ruleValue3) = " + countMatches(items2, ruleKey3, ruleValue3));
	}

	public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		int answer = 0;
		int index = ruleKey.equals("type") ? 0 : ruleKey.equals("color") ? 1 : 2;

		for (List<String> item : items) {
			if (item.get(index).equals(ruleValue)) {
				answer++;
			}
		}

		return answer;
	}
}
