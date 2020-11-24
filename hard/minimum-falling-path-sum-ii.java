class Solution {
    
    int n;
    
    public int minFallingPathSum(int[][] arr){
        int n = arr.length;
        
        
        int [][] dp = new int [n][n]; 
        for (int i =0; i< n; i++){
            dp[0][i] = arr[0][i];
        }

        for (int i =1; i< n; i++){

            for (int j =0; j< n; j++){

                int min =1000000;
                for (int w =0; w<n; w++){
                    if (w == j) continue;
                    
                    if (dp[i-1][w] + arr[i][j] < min){
                        min = dp [i-1][w] + arr[i][j];
                    }
                }
                dp[i][j] = min;
            }
        }
        
        int min = 100000;
        for (int i=0; i< n; i++){
            if (dp[n-1][i] < min){
                min = dp[n-1][i];
            }
        }
        return min; 
        
    }

}
