// Recursion 

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int ans = 0;
        int i = 0, j = 0;
        return solve(s1, s2, i,j);
        
    }
    public int solve(String s1, String s2, int i , int j){
        if(i >= s1.length() && j >= s2.length()) return 0;


        if(i >= s1.length() && j<s2.length()){
            int sum = 0;
            for(int k = j; k<s2.length(); k++){
                sum += s2.charAt(k);
            }
            return sum;
        }

        if(j >= s2.length() && i<s1.length()){
            int sum = 0;
            for(int k = i; k<s1.length(); k++){
                sum += s1.charAt(k);
            }
            return sum;
        }

        int ans;

        if(s1.charAt(i) == s2.charAt(j)){
            ans  = solve(s1, s2, i+1, j+1);
        }else{
            int takes1 = s2.charAt(j) + solve(s1, s2, i, j+1);
            int takes2 = s1.charAt(i) + solve(s1, s2, i+1, j);
            ans = Math.min(takes1, takes2);
        }
        
        
        
        return ans;
        
    }
    
}


// Memoiz

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int ans = 0;
        int i = 0, j = 0;
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        return solve(s1, s2, i,j, dp);
        
    }
    public int solve(String s1, String s2, int i , int j, int dp[][]){
        if(i >= s1.length() && j >= s2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(i >= s1.length() && j<s2.length()){
            int sum = 0;
            for(int k = j; k<s2.length(); k++){
                sum += s2.charAt(k);
            }
            return sum;
        }

        if(j >= s2.length() && i<s1.length()){
            int sum = 0;
            for(int k = i; k<s1.length(); k++){
                sum += s1.charAt(k);
            }
            return sum;
        }

        int ans;

        if(s1.charAt(i) == s2.charAt(j)){
            ans  = solve(s1, s2, i+1, j+1, dp);
        }else{
            int takes1 = s2.charAt(j) + solve(s1, s2, i, j+1, dp);
            int takes2 = s1.charAt(i) + solve(s1, s2, i+1, j, dp);
            ans = Math.min(takes1, takes2);
        }
        
        
        
        return dp[i][j] = ans;
        
    }
    
}