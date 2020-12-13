public class MaxProfit {
    //Solution1: 贪心算法思路，只要今天比昨天高就可以算作利润
    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }

        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i]){
                profit += prices[i + 1] - prices[i];
            }
        }

        return profit;
    }

    //Solution2: DP
    //状态转移：两种状态，要么是现金，要么是股票。
    //记录每一天的两种状态下最优解

    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length < 2){
            return 0;
        }

        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i][0] - prices[i]);
        }

        return dp[length - 1][0];
    }


}
