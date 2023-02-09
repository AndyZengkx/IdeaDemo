package main.practice;

import java.util.Scanner;

public class ConfusionMatrix {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        double TN = in.nextInt(), FP = in.nextInt(), TP = in.nextInt(), FN = in.nextInt();
        System.out.println((TP + TN) / (TP + TN + FP + FN));
        System.out.println((FP + FN) / (TP + TN + FP + FN));
        System.out.println(TN / (FP + TN));
        System.out.println(TP / (TP + FN));
        System.out.println(FN / (TP + FN));
        System.out.println(FP / (FP + TN));
        System.out.println(TP / (TP + FP));
        System.out.println(TP / (TP + FN));
    }
}