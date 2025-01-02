package main.java.dynamicProgramming;

/*
Problem statement :
You are given the weights and values of items, and you need to put these items in a knapsack of capacity
 to achieve the maximum total value in the knapsack. Each item is available in only one quantity.

In other words, you are given two integer arrays val[] and wt[], which represent the values and weights associated with items,
respectively. You are also given an integer capacity, which represents the knapsack capacity.
Your task is to find the maximum sum of values of a subset of val[] such that the
sum of the weights of the corresponding subset is less than or equal to capacity.
You cannot break an item; you must either pick the entire item or leave it (0-1 property).

Examples :

Input: capacity = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.
Input: capacity = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6]
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).
Input: capacity = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 6, 3]
Output: 90
Explanation: Choose the second item (value 40, weight 4) and the fourth item (value 50, weight 3) for a total weight of 7, which exceeds the capacity. Instead, pick the first item (value 10, weight 5) and the second item (value 40, weight 4) for a total value of 50.
Expected Time Complexity: O(n*capacity).
Expected Auxiliary Space: O(n*capacity)

Constraints:
2 ≤ val.size() = wt.size() ≤ 103
1 ≤ capacity ≤ 103
1 ≤ val[i] ≤ 103
1 ≤ wt[i] ≤ 103
 */
public class UnboundedKnapsack {


    public static void main(String[] args) {
        int profit[] = new int[]{60, 100, 120};
        int weight[] = new int[]{10, 20, 30};
        int W = 50;
        int n = profit.length;
        UnboundedKnapsack unboundedKnapsack = new UnboundedKnapsack();
        //o/p = 300 (10+10+10+10) for unbounded case
        System.out.println(unboundedKnapsack.knapsackRecursive(weight, profit, n, W));
        //o/p = 300 (10+10+10+10) for unbounded case
        System.out.println(unboundedKnapsack.knapsackTopDownApproach(weight, profit, n, W));

    }

    public int knapsackRecursive(int wt[], int val[], int n, int capacity) {
        if (n == 0 || capacity == 0) {
            return 0;
        }
        //Unbounded case - we can reconsider same weight again hence size of array - n never changes here
        //but if we don't select , it is considered as not selectable again, so size becomes n-1
        if (wt[n - 1] <= capacity) {
            return Math.max(val[n - 1] + knapsackRecursive(wt, val, n, capacity - wt[n - 1]),
                    knapsackRecursive(wt, val, n - 1, capacity));
        } else {
            return knapsackRecursive(wt, val, n - 1, capacity);
        }
    }

        public int knapsackTopDownApproach(int wt[], int val[], int n, int capacity) {
            int dp[][] = new int[n + 1][capacity + 1];
            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < capacity + 1; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 0; //base condition,
                        // if knapsack capacity = 0 or size of input =0 , profit is zero
                    }
                }
            }
            //Unbounded case - we can reconsider same weight again hence size of array -  i never changes here
            //but if we don't select , it is considered as not selectable again, so size becomes i-1
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < capacity + 1; j++) {
                    if (wt[i - 1] <= j) {
                        dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]],
                                dp[i - 1][j]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[n][capacity];

        }
}
