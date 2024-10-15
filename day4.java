package Coding_Chalenge;

import java.util.Scanner;

public class day4 {

    // Solution class definition
    static class Solution {
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void sortColors(int[] nums) {
            int mid = 0, low = 0, high = nums.length - 1;
            while (mid <= high) {
                if (nums[mid] == 0) {
                    swap(nums, mid, low);
                    low++;
                    mid++;
                } else if (nums[mid] == 1) {
                    mid++;
                } else {
                    swap(nums, mid, high);
                    high--;
                }
            }
        }
    }

    // Main method to test the Solution class
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        // int[] nums = {2, 0, 2, 1, 1, 0};
        Solution solution = new Solution();

        System.out.println("Before sorting:");
        printArray(nums);

        solution.sortColors(nums);

        System.out.println("After sorting:");
        printArray(nums);
    }

    // Helper method to print array elements
    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}



