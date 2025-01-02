package main.java.arrays.slidingWindow;

/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.



Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1]
[1,0,1,0]
[0,1,0,1]
[1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 */
public class BinarySubarrayWithSum {


    //wip
    public int findSum(int inputArr[], int goal) {
        int l = 0, r = 0, sum = 0, count = 0;
        while (l <= r && r < inputArr.length) {

            sum = sum + inputArr[r];
            if (sum <= goal) {
                count++;
            }
            if (sum > goal) {
                sum = sum - inputArr[l];
                l++;
            }

            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        int inputArr[] = {1, 0, 1, 0, 1};
        int goal = 2;
        BinarySubarrayWithSum binarySubarrayWithSum = new BinarySubarrayWithSum();
        System.out.println("Number of contiguous subarrays with goal :" + goal + " are :" + binarySubarrayWithSum.findSum(inputArr, goal));

        int inputArr1[] = {0, 0, 0, 0, 0};
        goal = 0;
        System.out.println("Number of contiguous subarrays with goal :" + goal + " are :" + binarySubarrayWithSum.findSum(inputArr1, goal));


    }

}
