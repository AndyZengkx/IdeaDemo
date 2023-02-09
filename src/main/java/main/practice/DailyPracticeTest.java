package main.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

public class DailyPracticeTest {

    private static void qSort(int[] nums, int l, int r){
        if(l>=r) return;
        int mid = nums[l], i = l, j = r;
        while(i < j){
            while(i < j && nums[j] >= mid) j--;
            while(i < j && nums[i] <= mid) i++;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        qSort(nums,l,j-1);
        qSort(nums,j+1,r);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String ...args){
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1};
        qSort(nums,0,nums.length-1);
        for(int num : nums) System.out.print(num+" ");
        System.out.println();
        int base = 1;
        for(int i = 0; i < 32; i++){
            System.out.println(i+ " " +base);
            base*=2;
        }
    }
}