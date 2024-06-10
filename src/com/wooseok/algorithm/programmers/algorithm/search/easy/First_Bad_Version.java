package com.wooseok.algorithm.programmers.algorithm.search.easy;

public class First_Bad_Version {

    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 1;
        int n3 = 4;

        int i = firstBadVersion(n1); // 4
        int i1 = firstBadVersion(n2); // 1
        int i2 = firstBadVersion(n3); // 1

        System.out.println("i = " + i);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
    }

    public static int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int middle = start + (end-start) / 2;
            boolean bad = isBadVersion(middle);

            if (bad == true) {
                end = middle;
            }

            if (bad == false) {
                start = middle + 1;
            }
        }
        return start;
    }

    private static boolean isBadVersion(int n) {
        switch (n) {
            case 1, 2, 3:
                return false;
        }
        return true;
    }
}
