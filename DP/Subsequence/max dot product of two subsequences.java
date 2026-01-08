// Recursion

class Solution {
    int m, n;

    public int maxDotProduct(int[] nums1, int[] nums2) {

        n = nums1.length;
        m = nums2.length;
        
        return solve(nums1, nums2, 0, 0);
    }

    public int solve(int[] nums1, int[] nums2, int i, int j){

        if(i >= n || j >= m){
            return -1000000000;
        }
        int pd = nums1[i]*nums2[j];
        int takej = solve(nums1, nums2, i, j+1);
        int takei = solve(nums1, nums2, i+1, j);
        int takeboth = nums1[i]*nums2[j] + solve(nums1, nums2, i+1, j+1);

        return Math.max(Math.max(takej, takei), Math.max(takeboth, pd));
    }
    
}

// Memoization

class Solution {
    int m, n;

    public int maxDotProduct(int[] nums1, int[] nums2) {

        n = nums1.length;
        m = nums2.length;

        int dp[][] = new int[n+1][m+1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return solve(nums1, nums2, 0, 0, dp);

        
    }

    public int solve(int[] nums1, int[] nums2, int i, int j, int dp[][]){

        if(i >= n || j >= m){
            return -1000000000;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int pd = nums1[i]*nums2[j];
        int takej = solve(nums1, nums2, i, j+1, dp);
        int takei = solve(nums1, nums2, i+1, j, dp);
        int takeboth = nums1[i]*nums2[j] + solve(nums1, nums2, i+1, j+1, dp);

        return dp[n][m] = Math.max(Math.max(takej, takei), Math.max(takeboth, pd));
    }
    
}

// Tabulation

class Solution {
    int m, n;

    public int maxDotProduct(int[] nums1, int[] nums2) {

        n = nums1.length;
        m = nums2.length;

        int dp[][] = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1000000000);
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                
                int pd = nums1[i]*nums2[j];
                int takej = dp[i][j+1];
                int takei = dp[i+1][j];
                int takeboth = nums1[i]*nums2[j] + dp[i+1][j+1];

                dp[i][j] = Math.max(Math.max(takej, takei), Math.max(takeboth, pd));
            }
        }

        return dp[0][0];

    }
    
}