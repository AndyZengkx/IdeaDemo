package main.practice;

import java.util.Scanner;

public class CalculateDistanceMatrix {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        int[][] points = new int[7][2];
        for (int i = 1; i <= 6; i++) {
            for (int j = 0; j < 2; j++)
                points[i][j] = in.nextInt();
        }
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                System.out.print(dis + " ");
            }
            System.out.println();
        }
    }
}
//0 3
//9 33
//21 9
//21 15
//33 15
//42 24
