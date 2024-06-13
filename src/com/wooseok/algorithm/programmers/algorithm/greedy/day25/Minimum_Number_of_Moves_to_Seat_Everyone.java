package com.wooseok.algorithm.programmers.algorithm.greedy.day25;

import java.util.Arrays;

public class Minimum_Number_of_Moves_to_Seat_Everyone {

    public static void main(String[] args) {
        int[] seats1 = {3, 1, 5};
        int[] seats2 = {4, 1, 5, 9};
        int[] seats3 = {2, 2, 6, 6};

        int[] students1 = {2, 7, 4};
        int[] students2 = {1, 3, 2, 6};

        // 4
        System.out.println("minMovesToSeat(seats1, students1) = " + minMovesToSeat(seats1, students1));
        // 7
        System.out.println("minMovesToSeat(seats2, students2) = " + minMovesToSeat(seats2, students2));
        // 4
        System.out.println("minMovesToSeat(seats3, students1) = " + minMovesToSeat(seats3, students2));

    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        int answer = 0;

        Arrays.sort(seats);
        Arrays.sort(students);

        for (int i = 0; i < students.length; i++) {
            answer += Math.abs(students[i] - seats[i]);
        }

        return answer;
    }
}
