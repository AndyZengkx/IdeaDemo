package main.practice;

public class PrePermutation {
    public static void main(String... args) {
        int[] nums = new int[]{5, 1, 1, 1};
        int left = nums.length - 2;
        while (left >= 0 && nums[left] <= nums[left + 1]) left--;
        if (left >= 0) {
            int right = nums.length - 1;
            while (right >= 0 && nums[left] <= nums[right]) right--;
            nums[left] ^= nums[right];
            nums[right] ^= nums[left];
            nums[left] ^= nums[right];
        }
        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();
        int l = left + 1, r = nums.length - 1;
        while (l < r) {
            nums[l] ^= nums[r];
            nums[r] ^= nums[l];
            nums[l] ^= nums[r];
            l++;
            r--;
        }
        for (int num : nums)
            System.out.print(num + " ");
    }
}
