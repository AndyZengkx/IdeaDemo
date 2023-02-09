package main.practice;

import java.util.Scanner;

public class Solution20221122 {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        StringBuilder ans = new StringBuilder();
        ans.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != str.charAt(i - 1)) ans.append(ch);
        }
        System.out.println(ans);
    }

}