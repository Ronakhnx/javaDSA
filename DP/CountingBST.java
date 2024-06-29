public class CountingBST {
    public static int countBST(int n) {
        // O(N^2)
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            // Ci -> BST (i nodes) -> dp[i]
            for (int j = 0; j < i; j++) {
                int left = dp[j];
                int right = dp[i - j - 1];
                dp[i] += left * right;
            }
        }
        return dp[n];
    }

    public static int mountainRange(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            // Ci -> BST (i nodes) -> dp[i]
            for (int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i - j - 1];
                dp[i] += inside * outside;
            }
        }
        return dp[n];

    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countBST(n));
    }
}
