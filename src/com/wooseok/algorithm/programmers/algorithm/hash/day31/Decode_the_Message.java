package com.wooseok.algorithm.programmers.algorithm.hash.day31;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Decode_the_Message {
	public static void main(String[] args) {
		String key1 = "the quick brown fox jumps over the lazy dog";
		String message1 = "vkbs bs t suepuv";

		String key2 = "eljuxhpwnyrdgtqkviszcfmabo";
		String message2 = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";

		// "this is a secret"
		System.out.println("decodeMessage(key1,message1) = " + decodeMessage(key1, message1));
		// "the five boxing wizards jump quickly"
		System.out.println("decodeMessage(key2, message2) = " + decodeMessage(key2, message2));
	}

	public static String decodeMessage(String key, String message) {
		StringBuilder answer = new StringBuilder();
		String[] alphabet =
			{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
				"v", "w", "x", "y", "z"};
		Set<Character> charSet = new LinkedHashSet<>();
		for (char c : key.toCharArray()) {
			if (c != ' ') {
				charSet.add(c);
			}
		}

		String[] keyArray = charSet.stream()
			.map(String::valueOf)
			.toArray(String[]::new);

		List<String> resultList = new ArrayList<>(List.of(keyArray));

		String[] messageArray = message.split("");

		for (String s : messageArray) {
			for (int i = 0; i < keyArray.length; i++) {
				if (s.equals(resultList.get(i))) {
					answer.append(alphabet[i]);
				}
			}
			if (s.equals(" ")) {
				answer.append(s);
			}
		}

		return answer.toString();
	}

	public static String decodeMessage2(String key, String message) {
		StringBuilder sb = new StringBuilder();
		key = key.replaceAll(" ", "");

		Hashtable<Character, Character> table = new Hashtable<>();

		char alphabet = 'a';
		for (int i = 0; i < key.length(); i++) {
			if (!table.containsKey(key.charAt(i))) {
				table.put(key.charAt(i), alphabet++);
			}
		}

		for (int i = 0; i < message.length(); i++) {
			if (table.containsKey(message.charAt(i))) {
				sb.append(table.get(message.charAt(i)));
			} else {
				sb.append(message.charAt(i));
			}
		}

		return sb.toString();
	}
}
