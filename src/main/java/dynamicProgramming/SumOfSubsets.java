package main.java.dynamicProgramming;

/*
Given an array arr[] of non-negative integers and a value sum, the task is to check if there is a subset of the given array whose sum is equal to the given sum.

Examples:

Input: arr[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
Explanation: There is a subset (4, 5) with sum 9.


Input: arr[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
Explanation: There is no subset that add up to 30.
 */

/*
This is a knapsack problem where weights is given and we have to get a target weight but no value array
 */
public class SumOfSubsets {


    public boolean sumOfSubsetExistTopDownApproach(int arr[], int n, int sum) {
        boolean dp[][] = new boolean[n + 1][sum + 1];//
        //row is the elements
        //column is the sum at any point
        for (int i = 0; i < n + 1; i++) { //i - number of elements selected
            for (int j = 0; j < sum + 1; j++) { // j = sum
                //base condition initialization
                if (j == 0) {
                    dp[i][j] = true; //1 way in which no of elements(i) can be any but sum (j) =0  i.e empty set
                }
                if (i == 0 && j != 0) {
                    dp[i][j] = false;// 0 ways in which sum ==j but no of elements (i) ==0
                }

            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    //j is sum at a given point
                    //we have two choices if value at arr[i-1] is less than sum (j)
                    // either include dp[i-1][j-arr[i-1]] or exclude dp[i-1] [j]
                    //dp[i-1] is basically a value precomputed at previous steps
                    // or will be computed at some point
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public int sumOfSubsetCountTopDownApproach(int arr[], int n, int sum) {
        int dp[][] = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                //base condition initialization
                if (j == 0) {
                    dp[i][j] = 1; //1 way in which no of elements(i) can be any but sum (j) =0  i.e empty set
                }
                if (i == 0 && j != 0) {
                    dp[i][j] = 0;// 0 ways in which sum ==j but no of elements (i) ==0
                }

            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    //j is sum at a given point
                    //we have two choices if value at arr[i-1] is less than sum (j)
                    // either include dp[i-1][j-arr[i-1]] or exclude dp[i-1] [j]
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        SumOfSubsets sumOfSubsets = new SumOfSubsets();
        System.out.println("Sum of subset check if exists : " + sumOfSubsets.sumOfSubsetExistTopDownApproach(arr, arr.length, sum));
        System.out.println("Sum of subset pairs count for given array : " + sumOfSubsets.sumOfSubsetCountTopDownApproach(arr, arr.length, sum));
        //4,3,2 and 4,5 - two pairs

        sum = 30; //no pairs exist
        System.out.println("Sum of subset check if exists : " + sumOfSubsets.sumOfSubsetExistTopDownApproach(arr, arr.length, sum));
        System.out.println("Sum of subset pairs count for given array : " + sumOfSubsets.sumOfSubsetCountTopDownApproach(arr, arr.length, sum));


    }
}
