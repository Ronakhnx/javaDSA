public class targetSum {
    //using tabulation
    public static boolean getTargetSum(int[] num, int targetSum) {
        int n = num.length;
        //i=ith item , j=targetSum
        boolean[][] dp = new boolean[n + 1][targetSum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < targetSum + 1; j++) {
                int v = num[i - 1];
                //include
                if (v <= j && dp[i - 1][j - v]) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][targetSum];
    }

    public static void main(String[] args) {
        int[] num = {4, 2, 7, 1, 3};
        int targetSum = 10;
        System.out.println(getTargetSum(num, targetSum));

    }

}

// target sum subset => num[=4,2,7,1,3] target=10;