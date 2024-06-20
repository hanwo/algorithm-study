package com.wooseok.algorithm.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class 추억점수 {

    public static void main(String args[]) {
        String[] name1 = {"may", "kein", "kain", "radi"};
        String[] name2 = {"kali", "mari", "don"};

        int[] yearing1 = {5, 10, 1, 3};
        int[] yearing2 = {11, 1, 55};

        String[][] photo1 = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        String[][] photo2 = {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};
        String[][] photo3 = {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}};

        System.out.println("solution(name1, yearing1, photo1) = " + Arrays.toString(solution(name1, yearing1, photo1)));
        System.out.println("solution(name2, yearing2, photo2) = " + Arrays.toString(solution(name2, yearing2, photo2)));
        System.out.println("solution(name1, yearing1, photo3) = " + Arrays.toString(solution(name1, yearing1, photo3)));
    }

    public static int[] solution(String[] names, int[] yearning, String[][] photos) {
        int[] answer = new int[photos.length];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            map.put(names[i], yearning[i]);
        }

        for (int j = 0; j < photos.length; j++) {
            int score = 0;
            String[] photo = photos[j];
            for (int i = 0; i < photo.length; i++) {
                if (map.containsKey(photo[i])) {
                    score += map.get(photo[i]);
                }
            }
            answer[j] = score;
        }
        return answer;
    }

}
