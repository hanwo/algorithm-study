package com.wooseok.algorithm.programmers.algorithm.dynamicprogramming.day20;

public class Fibonacci_Number {

    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 3;
        int n3 = 4;
        int fib = fib(n1);
        int fib1 = fib(n2);
        int fib2 = fib(n3);
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
