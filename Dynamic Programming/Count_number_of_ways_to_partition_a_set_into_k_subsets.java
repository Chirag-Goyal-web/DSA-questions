public class Count_number_of_ways_to_partition_a_set_into_k_subsets{
    
    //Memoization
    public static int divideInKGroup(int n, int k, int[][] dp) {
        if (n == k || k == 1) {
            return dp[n][k] = 1;
        }

        if (dp[n][k] != 0)
            return dp[n][k];

        int selfGroup = divideInKGroup(n - 1, k - 1, dp);
        int partOfGroup = divideInKGroup(n - 1, k, dp) * k;

        return dp[n][k] = selfGroup + partOfGroup;
    }

    //Tabulation
    public static int divideInKGroup_DP(int N, int K, int[][] dp) {
        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= K; k++) {
                if (n == k || k == 1) {
                    dp[n][k] = 1;
                    continue;
                }

                int selfGroup = dp[n - 1][k - 1];// divideInKGroup(n - 1, k - 1, dp);
                int partOfGroup = dp[n - 1][k] * k;// divideInKGroup(n - 1, k, dp) * k;

                dp[n][k] = selfGroup + partOfGroup;
            }
        }

        return dp[N][K];
    }

}