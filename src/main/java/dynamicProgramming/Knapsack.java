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
public class Knapsack {


    public static void main(String args[]) {
        int profit[] = new int[]{60, 100, 120};
        int weight[] = new int[]{10, 20, 30};
        int W = 50;
        int n = profit.length;
        Knapsack knapsack = new Knapsack();

        System.out.println(" Solution as per Top down knapsack : " + knapsack.knapsackTopDownApproach(weight, profit, n, W));

        System.out.println(" Solution as per recursive knapsack : " + knapsack.knapsackRecursive(weight, profit, n, W));
    }


    /*
    Time complexity and space complexity is 0(n*capacity)
    Only downside is sometimes can cause stack overflow due to high recursive calls if the array size or recursive computation is too high due to possible combinations
     */
    public int knapsackRecursive(int wt[], int val[], int n, int capacity) {

        if (n == 0 || capacity == 0) {
            //if no value in the array, or if capacity is 0 , we simply return o
            return 0; //base condition initialization
        }

        /* choice diagram either we add to knapsack or not
            depending on whether value of the weight Wi is less than knapsack capacity
         */
        if (wt[n - 1] <= capacity) {
            // if weight at index position is less than capacity either we add to the knapsack or we don't
            return Math.max(val[n - 1] + knapsackRecursive(wt, val, n - 1, capacity - wt[n - 1]),
                    knapsackRecursive(wt, val, n - 1, capacity));
        } else {
            //weight at index position is greater than capacity , so we simply don't add
            return knapsackRecursive(wt, val, n - 1, capacity);
        }

    }


    /*
    Time complexity and space complexity is 0(n*capacity)
    Extra benefit : To tackle stackoverflow error , we store (memoize) the computation at an instance in a 2d array ,
     to be reused later
    saves recomputation of previous results
     */
    public int knapsackTopDownApproach(int wt[], int val[], int n, int capacity) {
        int dp[][] = new int[n + 1][capacity + 1];
        //array to store computation result with size n+1 and w+1
        // because if we keep size dp[n][w], last value computed would be dp[n-1][w-1]
        // but the value we want is at dp[n][w] after computation of all values and visiting all weights

        for (int i = 0; i < n + 1; i++) { ////i - number of elements selected ,value gained by processing weights/elements selected at a given point
            for (int j = 0; j < capacity + 1; j++) { //j = capacity of knapsack at a given point
                if (i == 0 || j == 0) {
                    //if no value in the array, or if capacity is 0 , we simply return o
                   dp[i][j] =0; //base condition initialization
                }
            }
        }

        /* choice diagram either we add to knapsack or not
            dp[i][j] at any point is telling you what is the max profit
            as per the array processed until that point
         */
        for (int i = 1; i < n + 1; i++) { // no point in processing i= 0, j=0
            for (int j = 1; j < capacity + 1; j++) {
                if (wt[i - 1] <= j) {
                    // if weight at index position is less than capacity either we add to the knapsack or we don't
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]],
                            dp[i - 1][j]);
                } else {
                    //weight at index position is greater than capacity , so we simply don't add
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
        // dp[n][capacity] will always return
        // the maximum profit after the entire array is processed

    }


}
