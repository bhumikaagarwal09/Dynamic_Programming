ublic class Knapsack {

    public static int profit(int i, int[] wt, int[] val, int c, int[][] dp) {

        if (i == wt.length || c == 0) {
            return 0;
        }

        if (dp[i][c] != -1) {
            return dp[i][c];
        }

        int skip = profit(i + 1, wt, val, c, dp);

        if (wt[i] > c) {
            return dp[i][c] = skip;
        }

        int pick = val[i] + profit(i + 1, wt, val, c - wt[i], dp);

        return dp[i][c] = Math.max(pick, skip);
    }

    public static void main(String[] args) {
        int[] val = {5, 3, 9, 18};
        int[] wt = {1, 2, 4, 5};
        int c = 5;

        int n = wt.length;
        int[][] dp = new int[n][c + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(profit(0, wt, val, c, dp));
    }
}


Important: Your original condition should be if (wt[i] > c), not if (wt[i] <= c). If the item's weight exceeds the remaining capacity, you cannot pick it.
