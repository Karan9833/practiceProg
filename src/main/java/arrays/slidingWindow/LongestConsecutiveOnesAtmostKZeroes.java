package main.java.arrays.slidingWindow;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */
public class LongestConsecutiveOnesAtmostKZeroes {

    /*
    Time complexity =O(N^2)
    Space complexity = O(1)
     */
    public int findBruteForceLongestOnes(int inputArr[], int limit) {
        int k = 0, maxLen = 0;
        for (int i = 0; i < inputArr.length; i++) {
            k = 0;
            for (int j = i; j < inputArr.length; j++) {
                if (inputArr[j] == 0) {
                    k++;
                }
                if (k <= limit) {
                    //only limit number zeroes allowed
                    maxLen = Math.max(maxLen, j - i + 1);
                }
                if (k > limit) {
                    break;
                }
            }
        }
        return maxLen;
    }

    /*
    Time complexity : O(N)
    Space complexity : O(10
     */
    public int findLongestOnes(int inputArr[], int limit) {
        //Think of the question as we have max k zeroes allowed , instead of thinking of flipping 0s
        int l = 0, r = 0, maxLen = 0, k = 0;
        while (l <= r && r < inputArr.length) {
            if (inputArr[r] == 0) {
                k++;
            }
            if (k > limit) {
                if (inputArr[l] == 0) {
                    k--;
                }
                l++;
            }
            //only limit number zeroes allowed
            maxLen = Math.max(maxLen, r - l + 1);
            r++;

        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int k = 2;
        LongestConsecutiveOnesAtmostKZeroes longestConsecutiveOnesAtmostKZeroes = new LongestConsecutiveOnesAtmostKZeroes();
        System.out.println("Brute force approach for array :" + arr + " is : " + longestConsecutiveOnesAtmostKZeroes.findBruteForceLongestOnes(arr, k));
        System.out.println("Optimised approach for array :" + arr + " is : " + longestConsecutiveOnesAtmostKZeroes.findBruteForceLongestOnes(arr, k));

        int[] arr1 = {1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1};
        System.out.println("Brute force approach for array :" + arr1 + " is : " + longestConsecutiveOnesAtmostKZeroes.findBruteForceLongestOnes(arr1, k));
        System.out.println("Optimised approach for array :" + arr1 + " is : " + longestConsecutiveOnesAtmostKZeroes.findBruteForceLongestOnes(arr1, k));


        int nums[] = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println("Brute force approach for array :" + nums + " is :" + longestConsecutiveOnesAtmostKZeroes.findBruteForceLongestOnes(nums, 3));
        System.out.println("Optimised approach for array :" + nums + " is : " + longestConsecutiveOnesAtmostKZeroes.findLongestOnes(nums, 3));


        int nums1[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println("Brute force approach for array :" + nums1 + " is :" + longestConsecutiveOnesAtmostKZeroes.findBruteForceLongestOnes(nums1, 2));
        System.out.println("Optimised approach for array :" + nums1 + " is : " + longestConsecutiveOnesAtmostKZeroes.findLongestOnes(nums1, 2));

    }

}
