package DYNAMIC_PROGRAMMING;

import java.util.*;

public class climbing_stairs {
    // ~ /* Climbing stairs using recursion */
    public static int coutWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        // ! /* can also write above if conditions */
        /*
         *  if(n == 0 || n < 0)
         *  {
         ~      return n+1;
         * }
         */
        return coutWays(n - 1) + coutWays(n - 2);
    }
    // ! PROGRAMS TRHOUGH DYANAMIC PROGRAMMING
    // ~ /* Climbing Stairs through memoization */
    public static int countWaysMemoization(int n, int dp[])
    {
        if(n == 0 || n < 0)
        {
            return n+1;
        }
        if(dp[n] != -1)
        {
            return dp[n];
        }
        dp[n] = countWaysMemoization(n - 1, dp) + countWaysMemoization(n - 2, dp);
        return dp[n];
    }
    // ~ /* Climbing Stairs through tabulation */
    public static int countWaysTab(int n)
    {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if(i == 1){
                dp[i] = dp[i - 1] + 0;
            }
            else
            {
            dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n;
        System.out.println("Enter value of n (number of stairs).");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        // ? /* Another way of filling array */
        // * Arrays.fill(dp, 0, n+1, -1); 
        System.out.println(coutWays(n));
        System.out.println(countWaysMemoization(n, dp));
        System.out.println(countWaysTab(n));
        sc.close();
    }
}