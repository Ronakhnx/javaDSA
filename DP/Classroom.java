import java.util.Arrays;

public class Classroom {
    // using recursion
    public static int countWays(int n) {// O(2*n)
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countWays(n - 1) + countWays(n - 2);
    }

    // using memoization
    public static int countWaysMemo(int n, int[] ways) {// O(n)
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {// already calculated
            return ways[n];
        }
        ways[n] = countWays(n - 1) + countWays(n - 2);

        return ways[n];
    }

    // using tabulation
    public static int countWaysTableS(int n) {// O(n)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ways = new int[n + 1];
        Arrays.fill(ways, -1);
     //   System.out.println("maxWays:" + countWaysMemo(n, ways));
        System.out.println("maxWays:" + countWaysTableS(n));
    }
}