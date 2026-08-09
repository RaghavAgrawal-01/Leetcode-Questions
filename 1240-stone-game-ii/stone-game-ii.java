class Solution {
    int[][] dp;
    int[] sum;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        sum = new int[n + 1];
        dp = new int[n][n + 1];
        for(int i = n - 1; i >= 0; i--)
            sum[i] = sum[i + 1] + piles[i];

        return solve(piles, 0, 1);
    }
    int solve(int[] piles, int i, int m) {
        if(i >= piles.length)
            return 0;
        if(dp[i][m] != 0)
            return dp[i][m];
        int best = 0;
        for(int x = 1; x <= 2 * m && i + x <= piles.length; x++) 
        {
            int opponent = solve(piles, i + x, Math.max(m, x));
            best = Math.max(best, sum[i] - opponent);
        }
        return dp[i][m] = best;
    }
}