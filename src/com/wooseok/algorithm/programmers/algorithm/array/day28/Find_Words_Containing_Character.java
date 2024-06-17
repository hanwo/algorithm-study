package com.wooseok.algorithm.programmers.algorithm.array.day28;

import java.util.ArrayList;
import java.util.List;

public class Find_Words_Containing_Character {

	public static void main(String[] args) {
		String[] words1 = {"leet", "code"};
		String[] words2 = {"abc", "bcd", "aaaa", "cbc"};
		String[] words3 = {"abc", "bcd", "aaaa", "cbc"};

		char x1 = 'e';
		char x2 = 'a';
		char x3 = 'z';

		System.out.println("findWordsContaining(words1) = " + findWordsContaining(words1, x1));
		System.out.println("findWordsContaining(words2) = " + findWordsContaining(words2, x2));
		System.out.println("findWordsContaining(words3) = " + findWordsContaining(words3, x3));
	}

	public static List<Integer> findWordsContaining(String[] words, char x) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if(words[i].contains(String.valueOf(x))){
				list.add(i);
				break;
			}
		}
		return list;
	}
}
