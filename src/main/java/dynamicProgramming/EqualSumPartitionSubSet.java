package main.java.dynamicProgramming;

/*
Given an integer array nums, return true if you can partition the array into two subsets
 such that the sum of the elements in both subsets is equal or false otherwise.



Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.


Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */
public class EqualSumPartitionSubSet {

    public boolean checkEqualPartitionSubset(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        return new SumOfSubsets().sumOfSubsetExistTopDownApproach(arr, arr.length, sum / 2);
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 11, 5};
        EqualSumPartitionSubSet equalSumPartitionSubSet = new EqualSumPartitionSubSet();
        System.out.println("check if equal partition exists for given array: " + equalSumPartitionSubSet.checkEqualPartitionSubset(arr));
    }
}
