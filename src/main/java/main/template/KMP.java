package main.template;

import java.util.Scanner;

public class KMP {
    public static void main(String ... args){
//        Scanner input = new Scanner(System.in);
        String str = "mississippi", pattern = "issip";
        int[] next = new int[pattern.length()];
        int j = -1;
        next[0] = j;
        for(int i = 1; i < pattern.length(); i++){
            while(j>-1 && pattern.charAt(j+1)!=pattern.charAt(i)) j = next[j];
            if(pattern.charAt(j+1)==pattern.charAt(i)) j++;
            next[i] = j;
        }
        j = -1;
        for(int i = 0; i < str.length(); i++){
            while(j>-1 && pattern.charAt(j+1)!=str.charAt(i)) j = next[j];
            if(pattern.charAt(j+1)==str.charAt(i)) j++;
            if(j==pattern.length()-1){
                System.out.println(i-j);
                return;
            }
        }
    }
}
