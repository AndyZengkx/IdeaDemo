package main.practice;

import java.util.Scanner;

public class LogCalculate {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int n = 2;
        double ans = 0, b = in.nextInt();
        ;
        for (int i = 0; i < n; i++) {
            double a = in.nextInt();
            ans += a / b * Math.log(b / a) / Math.log(2);
        }
        System.out.println(ans);
    }
}
