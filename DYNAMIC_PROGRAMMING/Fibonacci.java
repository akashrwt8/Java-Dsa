package DYNAMIC_PROGRAMMING;

import java.util.Scanner;

// ~ Normal Recursion program -->>
public class Fibonacci {
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // ! Programs through Dynamic Programming -->>
    // ~ fibonacci through memoization ==>>
    public static int fib_DP(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fib_DP(n - 1, dp) + fib_DP(n - 2, dp);
        return dp[n];
    }

    // ~ fibonacci through tabulation ==>>
    public static int fib_dp_Tab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // !int n = 7;
        // ! int dp[] = new int[n + 1];
        // ! System.out.println(fib(n));
        // ! System.out.println(fib_DP(n, dp));
        int x;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value to caluculate fibonacci -->>");
        x = sc.nextInt();
        int dp[] = new int[x + 1];
        System.out.println(fib(x));
        System.out.println(fib_DP(x, dp));
        System.out.println(fib_dp_Tab(x));
        sc.close();
    }
}
