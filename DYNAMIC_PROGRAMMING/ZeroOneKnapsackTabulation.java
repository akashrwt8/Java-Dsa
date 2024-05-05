package DYNAMIC_PROGRAMMING;

// Time Complexity = O(nW)

public class ZeroOneKnapsackTabulation {
    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int zeroOneKnapsack(int dp[][], int val[], int wt[], int W) {
        int n = val.length;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // valid
                int value = val[i - 1]; // ith item value
                int weight = wt[i - 1]; // ith item weight
                if (weight <= j) {
                    // dp[i][j] = Math.max(value + dp[i - 1][j - weight], dp[i - 1][j]);
                    int includeProfit = value + dp[i - 1][j - weight];
                    int excludeProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(includeProfit, excludeProfit);
                } else { // invalid
                    // dp[i][j] = dp[i - 1][j];
                    int excludeProfit = dp[i - 1][j];
                    dp[i][j] = excludeProfit;
                }
            }
        }
        printDp(dp);
        return dp[n][W];
    }

    public static void main(String args[]) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int n = val.length;
        int W = 7;
        int dp[][] = new int[n + 1][W + 1];
        // initialize 0th row
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        // initialize 0th column
        for (int i = 0; i < dp.length; i++) {
                dp[i][0] = 0;
        }
        int ans = zeroOneKnapsack(dp, val, wt, W);
        System.out.println("Total profit of knapsack in this case will be " + ans);
    }
}
