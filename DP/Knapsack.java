public class Knapsack {
    // using recursion
    public static int knapSackRecursive(int[] val, int[] wt, int W, int n) {
        // O(2^N)
        if (W == 0 || n == 0) {
            return 0;
        }

        if (wt[n - 1] <= W) {// valid
            // Include
            int ans1 = val[n - 1] + knapSackRecursive(val, wt, W - wt[n - 1], n - 1);
            // Exclude
            int ans2 = knapSackRecursive(val, wt, W, n - 1);
            return Math.max(ans1, ans2);
        } else {
            return knapSackRecursive(val, wt, W, n - 1);
        }

    }

    // using memoization

    public static int knapSackMemo(int[] val, int[] wt, int W, int n, int dp[][]) {
        // O(n*W)
        if (W == 0 || n == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {// valid
            // Include
            int ans1 = val[n - 1] + knapSackMemo(val, wt, W - wt[n - 1], n - 1, dp);
            // Exclude
            int ans2 = knapSackMemo(val, wt, W, n - 1, dp);
            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {
            dp[n][W] = knapSackMemo(val, wt, W, n - 1, dp);
            return dp[n][W];
        }

    }

    // using tabulation
    public static int knapSackTabulation(int[] val, int[] wt, int W) {
        // O(n*W)
        //i=items,j=weight
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {// 0th column
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {// 0th row
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) {// valid
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {// invalid
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {

        int[] val = { 15, 14, 10, 45, 30 };
        int[] wt = { 2, 5, 1, 3, 4 };
        int W = 7;
        int[][] dp = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapSackTabulation(val, wt, W));

    }

}
